package controller;

import database.CirkelDAO;
import database.DBaccess;
import database.PuntDAO;
import model.Cirkel;
import model.Figuur;
import model.Punt;

import java.util.ArrayList;

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

        PuntDAO puntDAO = new PuntDAO(dBaccess);
        puntDAO.slaPuntOp(new Punt(8, -12));
        ArrayList<Punt> punten = puntDAO.getPunten();

        for (Punt punt : punten) {
            System.out.println(punt);
        }

        CirkelDAO cirkelDAO = new CirkelDAO(dBaccess);
        cirkelDAO.slaCirkelOp(new Cirkel(6.5, new Punt(-2.3, -1.3), "paars"));

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
