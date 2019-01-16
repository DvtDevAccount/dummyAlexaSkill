package de.axa.dvt.spielwiese.caseOne;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;
import de.axa.dvt.spielwiese.caseOne.handlers.FallbackIntentHandler;
import de.axa.dvt.spielwiese.caseOne.handlers.HelpIntentHandler;
import de.axa.dvt.spielwiese.caseOne.handlers.LaunchRequestHandler;
import de.axa.dvt.spielwiese.caseOne.handlers.SessionEndedRequestHandler;
import de.axa.dvt.spielwiese.caseOne.handlers.WhatsMyHaushaltIntentHandler;
import de.axa.dvt.spielwiese.caseOne.handlers.CancelandStopIntentHandler;
import de.axa.dvt.spielwiese.caseOne.handlers.MyHaushaltIsIntentHandler;

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
