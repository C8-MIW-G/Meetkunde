package controller;

import model.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Spelen met de meetkunde code
 */
public class MeetkundeLauncher {

    public static void main(String[] args) {
       Scanner keyboard = new Scanner(System.in);
       boolean onjuistInvoer = true;
       while (onjuistInvoer) {
           System.out.print("Geef een straal: ");
           try {
               double straal = keyboard.nextDouble();
               Cirkel ingevoerdeCirkel = new Cirkel(straal);
               System.out.println(ingevoerdeCirkel);
               onjuistInvoer = false;
           } catch (InputMismatchException fouteInvoer) {
               System.out.println("Je moet een kommagetal invoeren!");
               keyboard.nextLine();
           } catch (IllegalArgumentException fouteWaarde) {
               System.err.println(fouteWaarde.getMessage());
           } finally {
               System.out.println("Je goede of foute invoer is nu afgehandeld");
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
