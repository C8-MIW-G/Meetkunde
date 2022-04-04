package controller;

import model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Spelen met de meetkunde code
 */
public class MeetkundeLauncher {
    private static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String PREFIX_CONNECTION_URL =
            "jdbc:mysql://localhost:3306/";
    private static final String CONNECTION_SETTINGS = "?useSSL=false" +
            "&allowPublicKeyRetrieval=true" +
            "&useJDBCCompliantTimezoneShift=true" +
            "&useLegacyDatetimeCode=false" +
            "&serverTimezone=UTC";

    public static void main(String[] args) {
        String databaseName = "Figuren";
        String mainUser = "userFiguren";
        String mainUserPassword = "userFigurenPW";

        String connectionURL = PREFIX_CONNECTION_URL + databaseName + CONNECTION_SETTINGS;
        Connection connection = null;
        try {
            Class.forName(MYSQL_DRIVER);
            connection = DriverManager.getConnection(connectionURL, mainUser, mainUserPassword);
        } catch (ClassNotFoundException driverFout) {
            System.out.println("Driver niet gevonden");
        } catch (SQLException sqlFout) {
            System.out.println("SQL Exception: " + sqlFout.getMessage());
        }

        if (connection != null) {
            System.out.println("de verbinding is gemaakt!");

            String sql = "SELECT * FROM punt;";

            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    double xCoordinaat = resultSet.getDouble("xcoordinaat");
                    double yCoordinaat = resultSet.getDouble("ycoordinaat");
                    Punt punt = new Punt(xCoordinaat, yCoordinaat);
                    System.out.println(punt);
                }

                connection.close();
            } catch (SQLException sqlException) {
                System.out.println(sqlException);
            }
        }

    }

    public static void toonInformatie(Figuur figuur) {
        System.out.println(figuur);
    }

    public static void toonInformatieAlleFiguren(ArrayList<Figuur> figuren) {
        for (Figuur figuur : figuren) {
            toonInformatie(figuur);
            System.out.println();
        }
    }

}
