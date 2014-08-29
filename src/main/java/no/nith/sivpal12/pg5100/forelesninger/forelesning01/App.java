package no.nith.sivpal12.pg5100.forelesninger.forelesning01;

public class App {

    private View view;

    public App() {
        view = new View();
        view.printStats();
    }

    public static void main(String[] args) {
        new App();
    }

}
