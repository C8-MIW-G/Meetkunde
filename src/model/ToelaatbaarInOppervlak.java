package model;

/**
 * @author Vincent Velthuizen
 *
 * Geeft aan of een object op een oppervlak geplaatst kan worden
 */
public interface ToelaatbaarInOppervlak {

    boolean pastInOppervlak(double lengte, double breedte);

}
