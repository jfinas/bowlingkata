package de.klosebrothers.jfinas.bowlingkata;

import de.klosebrothers.jfinas.bowlingkata.bowlinggame.BowlingGame;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class BowlingController {
    @RequestMapping(value = "/bowlinggame/score",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json")
    // alternative namen: "/bowlinggame", "/bowlingscore"
    public BowlingGame calculateScore(@RequestBody BowlingGame bowlingGame) {
        try {
            return bowlingGame.selfCheck();// JSON-Serializer will calculate the score automatically
        } catch (BowlingException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }
}
