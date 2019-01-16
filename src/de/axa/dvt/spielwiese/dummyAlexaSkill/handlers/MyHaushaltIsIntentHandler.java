package de.axa.dvt.spielwiese.dummyAlexaSkill.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Request;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import static de.axa.dvt.spielwiese.dummyAlexaSkill.handlers.WhatsMyHaushaltIntentHandler.*;
import static de.axa.dvt.spielwiese.dummyAlexaSkill.handlers.WhatsMyHaushaltIntentHandler.HAUSHALT_KEY;
import static de.axa.dvt.spielwiese.dummyAlexaSkill.handlers.WhatsMyHaushaltIntentHandler.HAUSHALT_SLOT;
import static com.amazon.ask.request.Predicates.intentName;

public class MyHaushaltIsIntentHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("MyHaushaltIsIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        Request request = input.getRequestEnvelope().getRequest();
        IntentRequest intentRequest = (IntentRequest) request;
        Intent intent = intentRequest.getIntent();
        Map<String, Slot> slots = intent.getSlots();

        Slot favoriteHaushaltSlot = slots.get(HAUSHALT_SLOT);
        String speechText, repromptText;

        Haushalt haushalt = Haushalt.fromString(favoriteHaushaltSlot.getValue());

        if(haushalt != null && favoriteHaushaltSlot.getResolutions() != null && favoriteHaushaltSlot.getResolutions().toString().contains("ER_SUCCESS_MATCH")) {
            input.getAttributesManager().setSessionAttributes(Collections.singletonMap(HAUSHALT_KEY, haushalt));

            String auswahl = "Du hast " + haushalt + " ausgewaehlt.";
            speechText = auswahl + " Nächste Frage ...";
            repromptText = auswahl + "Bestaetigung ... Nächste Frage ...";

        } else {
            speechText = "Bitte nennen mir Dein Haushalt";
            repromptText = "Dein Haushalt Bitte";
        }

        return input.getResponseBuilder()
                .withSimpleCard("HaushaltSession", speechText)
                .withSpeech(speechText)
                .withReprompt(repromptText)
                .withShouldEndSession(false)
                .build();
    }

}
