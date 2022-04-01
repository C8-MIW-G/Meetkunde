package controller;

import model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Spelen met de meetkunde code
 */
public class MeetkundeLauncher {

    public static void main(String[] args) {
        ArrayList<String> regelsUitBestand = new ArrayList<>();
        File rechthoekenBestand = new File("resources/Rechthoek.csv");
        try {
            Scanner invoerBestand = new Scanner(rechthoekenBestand);
            while (invoerBestand.hasNextLine()) {
                regelsUitBestand.add(invoerBestand.nextLine());
            }
            invoerBestand.close();
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Het bestand is niet gevonden");
        }

        if (regelsUitBestand.size() > 0) {
            ArrayList<Rechthoek> rechthoeken = new ArrayList<>();
            for (String regel : regelsUitBestand) {
                String[] regelArray = regel.split(",");

                double lengte = Double.parseDouble(regelArray[0]);
                double breedte = Double.parseDouble(regelArray[1]);
                double xCoordinaat = Double.parseDouble(regelArray[2]);
                double yCoordinaat = Double.parseDouble(regelArray[3]);
                String kleur = regelArray[4];

                rechthoeken.add(new Rechthoek(lengte, breedte, new Punt(xCoordinaat, yCoordinaat), kleur));
            }

            for (Rechthoek rechthoek : rechthoeken) {
                System.out.println(rechthoek);
                System.out.println();
            }
        }
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
