package no.nith.sivpal12.pg5100.forelesninger.forelesning01;

import java.util.Scanner;

import no.nith.sivpal12.pg5100.forelesninger.forelesning01.data.store.Data;
import no.nith.sivpal12.pg5100.forelesninger.forelesning01.translators.ActionTranslator;

public class App {

    private static final String COMMAND_EXIT = "exit";

    public static void main(String[] args) {
        System.out.println("Avstemning av nasjonaldyr\n");

        Data.printStatus();

        try (Scanner consoleIn = new Scanner(System.in)) {
            String input = whatToDo(consoleIn);
            while (!COMMAND_EXIT.equalsIgnoreCase(input)) {
                switch (ActionTranslator.getAction(input)) {
                    case VOTE:
                        // TODO
                        break;
                    case UNKNOWN:
                    default:
                        System.out.println("Unknown command");
                        break;
                }
                input = whatToDo(consoleIn);
            }
            System.out.println("Exiting");
        }
    }

    private static String whatToDo(Scanner consoleIn) {
        System.out.println("Hva vil du gjøre?");
        return consoleIn.nextLine();
    }
}
