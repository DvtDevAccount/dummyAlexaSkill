package de.axa.dvt.spielwiese.dummyAlexaSkill.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.requestType;

public class LaunchRequestHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(requestType(LaunchRequest.class));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {

        String titel = "Wen möchten Sie versichern?";
        String gueltigerHaushalt = titel + "Ein Single, ein paar, eine Famile oder ein Single mit Kind.";
        String speechText = "Ansprache ... " + gueltigerHaushalt;
        String repromptText = "Ansprache Wiederholdung ... " + gueltigerHaushalt;

        return input.getResponseBuilder()
                .withSimpleCard(titel, speechText)
                .withSpeech(speechText)
                .withReprompt(repromptText)
                .build();
    }
}
