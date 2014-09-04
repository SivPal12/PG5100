package no.nith.sivpal12.pg5100.forelesninger.forelesning01;

import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try (Scanner consoleIn = new Scanner(System.in)) {
            new App(consoleIn).start();
        }
    }

}
