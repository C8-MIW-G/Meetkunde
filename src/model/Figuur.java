package model;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Beschrijft de algemene eigenschappen van een figuur
 */
public abstract class Figuur {
    protected static final double GRENSWAARDE_GROOT_FIGUUR = 100;
    protected static final String DEFAULT_KLEUR = "papaya whip";

    protected String kleur;

    public Figuur(String kleur) {
        this.kleur = kleur;
    }

    public Figuur(){
        this(DEFAULT_KLEUR);
    }

    public static String geefDefinitie() {
        return "Een figuur is een verzameling punten.";
    }

    public abstract double geefOmtrek();

    public abstract double geefOppervlakte();

    public String vertelOverGrootte() {
        if (this.geefOppervlakte() > GRENSWAARDE_GROOT_FIGUUR) {
            return "Ik ben groot!!!";
        } else {
            return "Ik ben klein!!!";
        }
    }

    @Override
    public String toString() {
        return String.format("Kleur: %s\nOmtrek: %f\nOppervlakte: %f", this.kleur, geefOmtrek(), geefOppervlakte());
    }

    public String getKleur() {
        return kleur;
    }

    public void setKleur(String kleur) {
        this.kleur = kleur;
    }
}
