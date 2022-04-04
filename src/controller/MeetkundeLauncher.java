package controller;

import database.DBaccess;
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

    public static void main(String[] args) {
        DBaccess dBaccess = new DBaccess("figuren",
                "userFiguren", "userFigurenPW");
        dBaccess.openConnection();

        Connection connection = dBaccess.getConnection();
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
        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        }

        dBaccess.closeConnection();
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
