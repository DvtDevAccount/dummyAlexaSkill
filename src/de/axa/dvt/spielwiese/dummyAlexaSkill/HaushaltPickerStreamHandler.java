package de.axa.dvt.spielwiese.dummyAlexaSkill;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;
import de.axa.dvt.spielwiese.dummyAlexaSkill.handlers.FallbackIntentHandler;
import de.axa.dvt.spielwiese.dummyAlexaSkill.handlers.HelpIntentHandler;
import de.axa.dvt.spielwiese.dummyAlexaSkill.handlers.LaunchRequestHandler;
import de.axa.dvt.spielwiese.dummyAlexaSkill.handlers.SessionEndedRequestHandler;
import de.axa.dvt.spielwiese.dummyAlexaSkill.handlers.WhatsMyHaushaltIntentHandler;
import de.axa.dvt.spielwiese.dummyAlexaSkill.handlers.CancelandStopIntentHandler;
import de.axa.dvt.spielwiese.dummyAlexaSkill.handlers.MyHaushaltIsIntentHandler;

public class HaushaltPickerStreamHandler extends SkillStreamHandler {

    private static Skill getSkill() {
        return Skills.standard()
                .addRequestHandlers(
                        new WhatsMyHaushaltIntentHandler(),
                        new MyHaushaltIsIntentHandler(),
                        new LaunchRequestHandler(),
                        new CancelandStopIntentHandler(),
                        new SessionEndedRequestHandler(),
                        new HelpIntentHandler(),
                        new FallbackIntentHandler())
                // Add your skill id below
                //.withSkillId("")
                .build();
    }

    public HaushaltPickerStreamHandler() {
        super(getSkill());
    }

}
