package de.axa.dvt.spielwiese.caseOne.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class WhatsMyHaushaltIntentHandler implements RequestHandler {
    public static final String HAUSHALT_KEY = "HAUSHALT";
    public static final String HAUSHALT_SLOT = "Haushalt";

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("WhatsMyHaushaltIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        String speechText;

        Haushalt ausgewaehlterHaushalt = Haushalt.fromString(input.getAttributesManager().getSessionAttributes().get(HAUSHALT_KEY).toString());

        boolean noAnswerProvided = false;

        if (ausgewaehlterHaushalt != null) {
            speechText = String.format("Dein Haushalt ist %s.", ausgewaehlterHaushalt);
        } else {
            speechText = "Ich habe Deinen Haushalt nicht verstanden. Bitte nenne mir Deinen Haushalt, ich bin zum Beispiel " + Haushalt.SINGLE;
            noAnswerProvided = true;
        }

        return input.getResponseBuilder()
                .withSimpleCard("HaushaltSession", speechText)
                .withSpeech(speechText)
                .withShouldEndSession(!noAnswerProvided)
                .build();
    }

    public enum Haushalt {
        SINGLE("Single"),
        PAAR("Paar"),
        FAMILIE("Familie"),
        SINGLE_MIT_KIND("Single mit Kind");

        private final String haushalt;

        Haushalt(final String haushalt) {
            this.haushalt = haushalt;
        }

        public String getHaushalt() {
            return haushalt;
        }

        public static Haushalt fromString(String text) {
            for (Haushalt b : Haushalt.values()) {
                if (b.getHaushalt().equalsIgnoreCase(text)) {
                    return b;
                }
            }
            return null;
        }
    }
}
