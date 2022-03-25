package model;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Beschrijft een cirkel
 */
public class Cirkel {
    public static final int DEFAULT_MIDDEL_PUNT_X = 0;
    public static final int DEFAULT_MIDDEL_PUNT_Y = 0;
    public static final String DEFAULT_KLEUR = "magenta";
    public static final int DEFAULT_STRAAL = 1;

    public double straal;
    public double middelPuntX;
    public double middelPuntY;
    public String kleur;

    // all args (arguments)
    public Cirkel(double straal, double middelPuntX, double middelPuntY, String kleur) {
        this.straal = straal;
        this.middelPuntX = middelPuntX;
        this.middelPuntY = middelPuntY;
        this.kleur = kleur;
    }

    public Cirkel(double straal) {
        this.straal = straal;
        this.middelPuntX = DEFAULT_MIDDEL_PUNT_X;
        this.middelPuntY = DEFAULT_MIDDEL_PUNT_Y;
        this.kleur = DEFAULT_KLEUR;
    }

    // default constructor
    public Cirkel() {
        this.straal = DEFAULT_STRAAL;
        this.middelPuntX = DEFAULT_MIDDEL_PUNT_X;
        this.middelPuntY = DEFAULT_MIDDEL_PUNT_Y;
        this.kleur = DEFAULT_KLEUR;
    }

    public static String geefDefinitie() {
        return "Een cirkel is een verzameling punten, die allemaal dezelfde\n" +
                "afstand tot een middelpunt hebben.";
    }

    public double geefOmtrek() {
        return 2 * Math.PI * straal;
    }

    public double geefOppervlakte() {
        return Math.PI * straal * straal;
    }
}
