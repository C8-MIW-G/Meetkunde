package controller;

import model.Cirkel;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Spelen met de meetkunde code
 */
public class MeetkundeLauncher {

    public static void main(String[] args) {
        Cirkel mijnCirkel = new Cirkel(3, 1, 4, "groen");
        Cirkel mijnTweedeCirkel = new Cirkel(1);
        System.out.println(mijnCirkel.geefOppervlakte());
        System.out.println(mijnTweedeCirkel.geefOppervlakte());
        System.out.println(Cirkel.geefDefinitie());
    }

}
