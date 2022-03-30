package model;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Beschijft een punt in de 2d ruimte
 */
public class Punt implements ToelaatbaarInOppervlak {
    private static final double DEFAULT_X = 0;
    private static final double DEFAULT_Y = 0;

    private double xCoordinaat;
    private double yCoordinaat;

    public Punt(double xCoordinaat, double yCoordinaat) {
        this.xCoordinaat = xCoordinaat;
        this.yCoordinaat = yCoordinaat;
    }

    public Punt() {
        this(DEFAULT_X, DEFAULT_Y);
    }

    public double getxCoordinaat() {
        return xCoordinaat;
    }

    public double getyCoordinaat() {
        return yCoordinaat;
    }

    @Override
    public String toString() {
        return String.format("(%.1f, %.1f)", xCoordinaat, yCoordinaat);
    }

    @Override
    public boolean pastInOppervlak(double lengte, double breedte) {
        return true;
    }
}
