package database;

import model.Punt;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PuntDAO extends AbstractDAO  {
    public PuntDAO(DBaccess dBaccess) {
        super(dBaccess);
    }

    public ArrayList<Punt> getPunten() {
        ArrayList<Punt> puntenLijst = new ArrayList<>();
        String sql = "SELECT * FROM punt;";
        try {
            setupPreparedStatement(sql);
            ResultSet resultSet = executeSelectStatement();
            while (resultSet.next()) {
                Punt punt = new Punt(resultSet.getDouble("xcoordinaat"),
                        resultSet.getDouble("ycoordinaat"));
                puntenLijst.add(punt);
            }
        } catch (SQLException sqlFout) {
            System.out.println(sqlFout);
        }
        return puntenLijst;
    }

    public void slaPuntOp(Punt punt) {
        String sql = "INSERT INTO punt VALUES(?, ?)";
        try {
            setupPreparedStatement(sql);
            preparedStatement.setDouble(1, punt.getxCoordinaat());
            preparedStatement.setDouble(2, punt.getyCoordinaat());
            executeManipulateStatement();
        } catch (SQLException sqlFout) {
            System.out.println(sqlFout);
        }
    }
}
