package no.nith.sivpal12.pg5100.forelesninger.forelesning01.translators;

import no.nith.sivpal12.pg5100.forelesninger.forelesning01.enums.Action;

public class ActionTranslator {

    public static Action getAction(String input) {
        for (Action action : Action.values()) {
            if (action.name().equalsIgnoreCase(input)) {
                return action;
            }
        }
        return Action.UNKNOWN;
    }

}
