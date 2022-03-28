package controller;

import model.Cirkel;

import java.util.Scanner;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Spelen met de meetkunde code
 */
public class MeetkundeLauncher {

    public static void main(String[] args) {
        Cirkel[] cirkels = new Cirkel[3];
        cirkels[0] = new Cirkel(3, 1, 4, "groen");
        cirkels[1] = new Cirkel();
        cirkels[2] = new Cirkel(6);

        for (int i = 0; i < cirkels.length; i++) {
            System.out.println(cirkels[i].getStraal());
            System.out.println(cirkels[i].geefOppervlakte());
            System.out.println(cirkels[i].geefOmtrek());
        }
    }

}
