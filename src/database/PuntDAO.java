package database;

import model.Punt;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PuntDAO  {
    
    private DBaccess dBaccess;
    
    public PuntDAO(DBaccess dBaccess) {
        this.dBaccess = dBaccess;
    }

    public ArrayList<Punt> getPunten() {
        ArrayList<Punt> puntenLijst = new ArrayList<>();
        String sql = "SELECT * FROM punt;";
        try {
            PreparedStatement preparedStatement = 
                dBaccess.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
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
            PreparedStatement preparedStatement = 
                dBaccess.getConnection().prepareStatement(sql);
            preparedStatement.setDouble(1, punt.getxCoordinaat());
            preparedStatement.setDouble(2, punt.getyCoordinaat());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlFout) {
            System.out.println(sqlFout);
        }
    }
}
