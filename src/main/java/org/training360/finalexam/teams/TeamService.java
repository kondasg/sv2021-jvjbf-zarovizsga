package org.training360.finalexam.teams;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.training360.finalexam.players.*;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.List;

@Service
@AllArgsConstructor
public class TeamService {

    private TeamRepository teamRepository;
    private PlayerRepository playerRepository;
    private PlayerService playerService;
    private ModelMapper modelMapper;

    public List<TeamDTO> getAllTeams() {
        Type targetListType = new TypeToken<List<TeamDTO>>() {}.getType();
        return modelMapper.map(teamRepository.findAll(), targetListType);
    }

    public TeamDTO createTeam(CreateTeamCommand command) {
        Team team = new Team(command.getName());
        teamRepository.save(team);
        return modelMapper.map(team, TeamDTO.class);
    }

    @Transactional
    public TeamDTO createPlayerAndAddTeam(Long id, CreatePlayerCommand command) {
        Team team = getTeamById(id);
        Player player = new Player(command.getName(), command.getBirthDate(), command.getPosition(), team);
        team.addPlayer(player);
        return modelMapper.map(team, TeamDTO.class);
    }

    @Transactional
    public TeamDTO modifyPlayerTeam(Long id, UpdateWithExistingPlayerCommand command) {
        Player player = playerService.getPlayerById(command.getId());
        Team team = getTeamById(id);
        if (player.getTeam() == null && playerRepository.countPositionByTeamId(id, player.getPosition()) < 2) {
            team.addPlayer(player);
        }
        return modelMapper.map(team, TeamDTO.class);
    }

    private Team getTeamById(Long id) {
        return teamRepository.findById(id)
                .orElseThrow(() -> new TeamNotFoundException("Team id not found: " + id));
    }
}
