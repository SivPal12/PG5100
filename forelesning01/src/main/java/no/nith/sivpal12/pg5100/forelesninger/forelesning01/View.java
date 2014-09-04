package no.nith.sivpal12.pg5100.forelesninger.forelesning01;

import no.nith.sivpal12.pg5100.forelesninger.forelesning01.constants.OutputConstants;
import no.nith.sivpal12.pg5100.forelesninger.forelesning01.constants.db.Tables;
import no.nith.sivpal12.pg5100.forelesninger.forelesning01.data.store.Data;
import no.nith.sivpal12.pg5100.forelesninger.forelesning01.pojo.Animal;

public class View {

    public void printStats() {
        System.out.println(String.format(OutputConstants.ANIMALS_NAME_VOTES,
                Tables.NASJONALDYR_COLUMN_ART,
                Tables.NASJONALDYR_COLUMN_STEMMER));
        for (Animal animal : Data.getAllAnimals()) {
            System.out.println(String.format(
                    OutputConstants.ANIMALS_NAME_VOTES, animal.getName(),
                    animal.getVotes()));
        }
    }

}
