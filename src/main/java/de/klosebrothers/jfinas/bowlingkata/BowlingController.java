package de.klosebrothers.jfinas.bowlingkata;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BowlingController {
    @RequestMapping(value = "/bowlinggame/score", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    // alternative namen: "/bowlinggame", "/bowlingscore"
    // TODO: write integration-test?
    // TODO: implement error-handling & robustness-measures
    public BowlingGame calculateScore(@RequestBody BowlingGame bowlingGame) {
        return bowlingGame;// JSON-Serializer will calculate the score automatically
    }
}
