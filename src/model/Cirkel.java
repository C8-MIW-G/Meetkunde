package model;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Beschrijft een cirkel
 */
public class Cirkel extends Figuur {
    private static final double DEFAULT_STRAAL = 1;

    private double straal;
    private Punt middelpunt;

    // all args (arguments)
    public Cirkel(double straal, Punt middelpunt, String kleur) {
        super(kleur);
        setStraal(straal);
        this.middelpunt = middelpunt;
    }

    public Cirkel(double straal) {
        // alternatief ter illustratie
//        super();
//        setStraal(straal);
//        this.middelpunt = new Punt();

        this(straal, new Punt(), DEFAULT_KLEUR);
    }

    // default constructor
    public Cirkel() {
        this(DEFAULT_STRAAL);
    }

    public static String geefDefinitie() {
        return "Een cirkel is een verzameling punten, die allemaal dezelfde\n" +
                "afstand tot een middelpunt hebben.";
    }

    @Override
    public double geefOmtrek() {
        return 2 * Math.PI * straal;
    }

    @Override
    public double geefOppervlakte() {
        return Math.PI * straal * straal;
    }

    @Override
    public String toString() {
        return String.format("%s\nStraal: %f\nMiddelpunt: %s", super.toString(), this.straal, this.middelpunt);
    }

    @Override
    public boolean pastInOppervlak(double lengte, double breedte) {
        return straal <= breedte / 2;
    }

    public double getStraal() {
        return straal;
    }

    public void setStraal(double straal) {
        if (straal <= 0) {
            throw new IllegalArgumentException("De straal moet positief zijn.");
        }
        this.straal = straal;
    }

    public Punt getMiddelpunt() {
        return middelpunt;
    }
}
