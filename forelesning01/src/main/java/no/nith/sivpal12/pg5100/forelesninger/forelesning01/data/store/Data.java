package no.nith.sivpal12.pg5100.forelesninger.forelesning01.data.store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Data {

    private static final String COLUMN_STEMMER = "stemmer";
    private static final String COLUMN_ART = "art";
    private static final String SQL_ALL = "select * from NASJONALDYR";

    static {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void printStatus() {
        try (Connection conn = getConnection();
                PreparedStatement ps = conn
                        .prepareStatement(SQL_ALL);
                ResultSet rs = ps.executeQuery()) {
            System.out.println("Art          Stemmer");
            while (rs.next()) {
                System.out.println(String.format("%-12s %7d",
                        rs.getString(COLUMN_ART), rs.getInt(COLUMN_STEMMER)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
    }

}
