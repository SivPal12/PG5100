package no.nith.sivpal12.pg5100.forelesninger.forelesning01;

import java.util.Scanner;

import no.nith.sivpal12.pg5100.forelesninger.forelesning01.data.store.Data;
import no.nith.sivpal12.pg5100.forelesninger.forelesning01.enums.WhatToDo;

public class App {

    private final View view;
    private final Scanner input;

    public App(Scanner input) {
        this.input = input;
        view = new View();
    }

    public void start() {
        view.printStats();
        switch (whatToDo(input)) {
            case VOTE:
                vote();
                break;

            default:
                break;
        }
    }

    private void vote() {
        System.out.println("Hvilket dyr vil du stemme på?");
        view.printStats();
        Data.voteFor(input.nextLine());
    }

    private WhatToDo whatToDo(Scanner input2) {
        // TODO Implement
        return WhatToDo.VOTE;
    }

}
