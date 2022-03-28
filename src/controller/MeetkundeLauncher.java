package controller;

import model.Cirkel;
import model.Punt;
import model.Rechthoek;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Spelen met de meetkunde code
 */
public class MeetkundeLauncher {

    public static void main(String[] args) {
        Cirkel[] cirkels = new Cirkel[3];
        cirkels[0] = new Cirkel(3, new Punt(1, 4), "groen");
        cirkels[1] = new Cirkel();
        cirkels[2] = new Cirkel(6);

        for (int i = 0; i < cirkels.length; i++) {
            System.out.println(cirkels[i].getStraal());
            System.out.println(cirkels[i].geefOppervlakte());
            System.out.println(cirkels[i].geefOmtrek());
            System.out.printf("(%.1f, %.1f)\n",
                    cirkels[i].getMiddelpunt().getxCoordinaat(),
                    cirkels[i].getMiddelpunt().getyCoordinaat());
        }

        System.out.println(Rechthoek.geefDefinitie());
        Rechthoek[] mijnRechthoekArray = new Rechthoek[3];
        mijnRechthoekArray[0] = new Rechthoek(4, 3, new Punt(2, 5), "blauw");
        mijnRechthoekArray[1] = new Rechthoek();
        mijnRechthoekArray[2] = new Rechthoek(25, 10);
        for (int arrayTeller = 0; arrayTeller < mijnRechthoekArray.length;
             arrayTeller++) {
            System.out.println(mijnRechthoekArray[arrayTeller].geefOmtrek());
            System.out.println(mijnRechthoekArray[arrayTeller].geefOppervlakte());
            System.out.println(mijnRechthoekArray[arrayTeller].
                    getHoekpuntLinksBoven().getxCoordinaat());
            System.out.println(mijnRechthoekArray[arrayTeller].
                    getHoekpuntLinksBoven().getyCoordinaat());
            System.out.println(mijnRechthoekArray[arrayTeller].
                    vertelOverGrootte());
        }
    }

}
