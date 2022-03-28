package model;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Beschrijft een cirkel
 */
public class Cirkel {
    private static final double GRENSWAARDE_GROOT_FIGUUR = 100;
    private static final double DEFAULT_MIDDEL_PUNT_X = 0;
    private static final double DEFAULT_MIDDEL_PUNT_Y = 0;
    private static final String DEFAULT_KLEUR = "magenta";
    private static final double DEFAULT_STRAAL = 1;

    private double straal;
    private double middelPuntX;
    private double middelPuntY;
    private String kleur;

    // all args (arguments)
    public Cirkel(double straal, double middelPuntX, double middelPuntY, String kleur) {
        setStraal(straal);
        this.middelPuntX = middelPuntX;
        this.middelPuntY = middelPuntY;
        this.kleur = kleur;
    }

    public Cirkel(double straal) {
        this(straal, DEFAULT_MIDDEL_PUNT_X, DEFAULT_MIDDEL_PUNT_Y, DEFAULT_KLEUR);
    }

    // default constructor
    public Cirkel() {
        this(DEFAULT_STRAAL);
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

    public String vertelOverGrootte() {
        if (this.geefOppervlakte() > GRENSWAARDE_GROOT_FIGUUR) {
            return "Ik ben groot!!!";
        } else {
            return "Ik ben klein!!!";
        }
    }

    public double getStraal() {
        return straal;
    }

    public void setStraal(double straal) {
        if (straal > 0) {
            this.straal = straal;
        } else {
            System.out.printf("De straal moet positief zijn. De straal wordt op %.1f gezet.\n",
                    DEFAULT_STRAAL);
            this.straal = DEFAULT_STRAAL;
        }
    }
}
