package model;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Beschrijft een figuur met vier rechte hoeken
 */
public class Rechthoek extends Figuur {
    private static final int DEFAULT_LENGTE = 2;
    private static final int DEFAULT_BREEDTE = 1;

    private double lengte;
    private double breedte;
    private Punt hoekpuntLinksBoven;

    public Rechthoek(double lengte, double breedte, Punt hoekpuntLinksBoven, String kleur) {
        super(kleur);
        this.lengte = lengte;
        this.breedte = breedte;
        this.hoekpuntLinksBoven = hoekpuntLinksBoven;
    }

    public Rechthoek(double lengte, double breedte) {
        this(lengte, breedte, new Punt(), DEFAULT_KLEUR);
    }

    public Rechthoek() {
        this(DEFAULT_LENGTE, DEFAULT_BREEDTE);
    }

    public static String geefDefinitie() {
        return "Een rechthoek is een vierhoek met vier rechte hoeken.";
    }

    @Override
    public double geefOmtrek() {
        return 2 * (lengte + breedte);
    }

    @Override
    public double geefOppervlakte() {
        return lengte * breedte;
    }

    @Override
    public String toString() {
        return String.format("%s\nLengte: %f\nBreedte: %f\nHoekpuntLinksBoven: %s", super.toString(), this.lengte, this.breedte, this.hoekpuntLinksBoven);
    }

    public Punt getHoekpuntLinksBoven() {
        return hoekpuntLinksBoven;
    }

    public double getLengte() {
        return lengte;
    }

    public double getBreedte() {
        return breedte;
    }
}
