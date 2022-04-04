package database;

import model.Cirkel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Schrijft en leest Cirkel objecten naar en van de Database
 */
public class CirkelDAO {
    DBaccess dBaccess;

    public CirkelDAO(DBaccess dBaccess) {
        this.dBaccess = dBaccess;
    }

    public void slaCirkelOp(Cirkel cirkel) {
        String sqlFiguur = "INSERT INTO figuur(kleur) VALUES (?);";
        int primaryKey = 0;
        try {
            PreparedStatement preparedStatement =
                    dBaccess.getConnection().prepareStatement(sqlFiguur, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, cirkel.getKleur());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                primaryKey = resultSet.getInt(1);
                System.out.printf("De toegevoeged sleutel is: %d\n", primaryKey);
            }
        } catch (SQLException sqlException) {
            System.out.println("Er was een SQL probleem: " + sqlException.getMessage());
        }

        String sqlCirkel = "INSERT INTO cirkel VALUES (?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = dBaccess.getConnection().prepareStatement(sqlCirkel);
            preparedStatement.setInt(1, primaryKey);
            preparedStatement.setDouble(2, cirkel.getStraal());
            preparedStatement.setDouble(3, cirkel.getMiddelpunt().getxCoordinaat());
            preparedStatement.setDouble(4, cirkel.getMiddelpunt().getyCoordinaat());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println("Er was een SQL probleem: " + sqlException.getMessage());
        }
    }
}
