package no.nith.sivpal12.pg5100.forelesninger.forelesning01.data.store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import no.nith.sivpal12.pg5100.forelesninger.forelesning01.constants.db.Sql;
import no.nith.sivpal12.pg5100.forelesninger.forelesning01.constants.db.Tables;
import no.nith.sivpal12.pg5100.forelesninger.forelesning01.pojo.Animal;

public class Data {

    static {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
    }

    public static List<Animal> getAllAnimals() {
        List<Animal> animals = new LinkedList<>();
        try (Connection conn = getConnection();
                PreparedStatement ps = conn
                        .prepareStatement(Sql.NASJONALDYR_SQL_ALL);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                animals.add(new Animal(
                        rs.getString(Tables.NASJONALDYR_COLUMN_ART),
                        rs.getInt(Tables.NASJONALDYR_COLUMN_STEMMER)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return animals;
    }

    public static void voteFor(String art) {
        try (Connection conn = getConnection();
                PreparedStatement ps = conn
                        .prepareStatement(Sql.NASJONALDYR_UPDATE_VOTE);) {
            ps.setString(1, art);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
