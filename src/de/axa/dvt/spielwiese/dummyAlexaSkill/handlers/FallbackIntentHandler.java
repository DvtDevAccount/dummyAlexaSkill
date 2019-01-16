package de.axa.dvt.spielwiese.dummyAlexaSkill.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class FallbackIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("AMAZON.FallbackIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        String speechText = "Entschuldigung ich habe Dich nicht verstanden. Du kannst Hilfe sagen für weitere Unterstützung!";
        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("Unterstützung", speechText)
                .withReprompt(speechText)
                .build();
    }

}
