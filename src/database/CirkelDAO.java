package database;

import model.Cirkel;

import java.sql.SQLException;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Schrijft en leest Cirkel objecten naar en van de Database
 */
public class CirkelDAO extends AbstractDAO{
    public CirkelDAO(DBaccess dBaccess) {
        super(dBaccess);
    }

    public void slaCirkelOp(Cirkel cirkel) {
        String sqlFiguur = "INSERT INTO figuur(kleur) VALUES (?);";
        int primaryKey = 0;
        try {
            setupPreparedStatementWithKey(sqlFiguur);
            preparedStatement.setString(1, cirkel.getKleur());
            primaryKey = executeInsertStatementWithKey();
        } catch (SQLException sqlException) {
            System.out.println("Er was een SQL probleem: " + sqlException.getMessage());
        }

        String sqlCirkel = "INSERT INTO cirkel VALUES (?, ?, ?, ?);";
        try {
            setupPreparedStatement(sqlCirkel);
            preparedStatement.setInt(1, primaryKey);
            preparedStatement.setDouble(2, cirkel.getStraal());
            preparedStatement.setDouble(3, cirkel.getMiddelpunt().getxCoordinaat());
            preparedStatement.setDouble(4, cirkel.getMiddelpunt().getyCoordinaat());
            executeManipulateStatement();
        } catch (SQLException sqlException) {
            System.out.println("Er was een SQL probleem: " + sqlException.getMessage());
        }
    }
}
