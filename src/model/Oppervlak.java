package model;

import java.util.ArrayList;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Een oppervlak waar figuren op gezet kunnen worden
 */
public class Oppervlak {
    private double lengte;
    private double breedte;
    private ArrayList<Figuur> mijnFiguren;

    public Oppervlak(double lengte, double breedte) {
        this.lengte = lengte;
        this.breedte = breedte;
        this.mijnFiguren = new ArrayList<>();
    }

    public void voegFiguurToe(Figuur figuur) {
        if (figuurPastAlsVormInOppervlak(figuur)) {
            mijnFiguren.add(figuur);
            System.out.println("Dit figuur is toegevoegd");
        } else {
            System.out.println("Dit figuur is te groot");
        }
    }

    public ArrayList<Figuur> geefFigurenMetGrotereOppervlakte(double grenswaarde) {
        ArrayList<Figuur> gevraagdeFiguren = new ArrayList<>();

        for (Figuur figuurTerOverweging : mijnFiguren) {
            if (figuurTerOverweging.geefOppervlakte() > grenswaarde) {
                gevraagdeFiguren.add(figuurTerOverweging);
            }
        }

        return gevraagdeFiguren;
    }

    private boolean figuurPastAlsVormInOppervlak(Figuur figuur) {
        boolean eenReturn = false;

        if (figuur instanceof Rechthoek) {
            if (((Rechthoek) figuur).getLengte() <= lengte && ((Rechthoek) figuur).getBreedte() <= breedte) {
                eenReturn = true;
            }
        } else if (figuur instanceof Cirkel) {
            if (((Cirkel) figuur).getStraal() <= breedte / 2) {
                eenReturn = true;
            }
        }

        return eenReturn;
    }

    @Override
    public String toString() {
        String eenReturn = "";

        for (Figuur figuur : mijnFiguren) {
            eenReturn += figuur.toString() + "\n\n";
        }

        return eenReturn;
    }

    public ArrayList<Figuur> getMijnFiguren() {
        return mijnFiguren;
    }
}
