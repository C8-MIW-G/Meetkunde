package model;

import java.util.ArrayList;
import java.util.Collections;

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
        if (figuur.pastInOppervlak(lengte, breedte)) {
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

    @Override
    public String toString() {
        StringBuilder eenReturn = new StringBuilder();

        Collections.sort(mijnFiguren);

        for (Figuur figuur : mijnFiguren) {
            eenReturn.append(String.format("%s\n\n", figuur.toString()));
        }

        return eenReturn.toString();
    }

    public ArrayList<Figuur> getMijnFiguren() {
        return mijnFiguren;
    }
}
