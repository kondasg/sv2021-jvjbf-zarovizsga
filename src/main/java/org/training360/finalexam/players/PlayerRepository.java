package org.training360.finalexam.players;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query("SELECT count(p) FROM Player p WHERE p.team.id = :id AND p.position = :position")
    int countPositionByTeamId(Long id, PositionType position);
}
