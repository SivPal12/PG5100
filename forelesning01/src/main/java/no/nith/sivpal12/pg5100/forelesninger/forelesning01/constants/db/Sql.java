package no.nith.sivpal12.pg5100.forelesninger.forelesning01.constants.db;

public class Sql {

    public static final String NASJONALDYR_SQL_ALL = "select * from NASJONALDYR";
    // public static final String NASJONALDYR_GET_ROW =
    // "select * from nasjonaldyr where art like '?'";
    public static final String NASJONALDYR_UPDATE_VOTE = "update nasjonaldyr set stemmer = stemmer + 1 where art like '?';";

}
