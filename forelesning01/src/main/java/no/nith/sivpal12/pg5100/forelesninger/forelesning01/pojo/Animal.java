package no.nith.sivpal12.pg5100.forelesninger.forelesning01.pojo;

public class Animal {

    private final String name;
    private final int votes;

    public Animal(String name, int votes) {
        this.name = name;
        this.votes = votes;
    }

    public String getName() {
        return name;
    }

    public int getVotes() {
        return votes;
    }

}
