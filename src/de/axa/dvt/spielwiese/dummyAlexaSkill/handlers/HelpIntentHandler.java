package de.axa.dvt.spielwiese.dummyAlexaSkill.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class HelpIntentHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("AMAZON.HelpIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {

        //FIXME: Fortschritt und Hilfe-Seit erkennen
        String speechText = "Was ist Dein Haushalt? Meiner ist Single";
        String repromptText = "Was ist Dein Haushalt? Meiner ist Single";
        return input.getResponseBuilder()
                .withSimpleCard("Fallback", speechText)
                .withSpeech(speechText)
                .withReprompt(repromptText)
                .withShouldEndSession(false)
                .build();
    }
}
