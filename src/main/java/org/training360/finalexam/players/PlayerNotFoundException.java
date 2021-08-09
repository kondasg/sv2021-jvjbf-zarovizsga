package org.training360.finalexam.players;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;
public class PlayerNotFoundException extends AbstractThrowableProblem {

    public PlayerNotFoundException(String message) {
        super(URI.create("player/not-found"),
                "Not found",
                Status.NOT_FOUND,
                message);
    }
}

