package no.nith.sivpal12.pg5100.forelesninger.forelesning01.data.store;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class DataTest {

    @Test
    public void getAllAnimals_NotNull() throws Exception {
        assertNotNull(Data.getAllAnimals());
    }

}
