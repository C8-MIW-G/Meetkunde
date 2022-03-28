package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RechthoekTest {

    @Test
    @DisplayName("Definitie van een Rechthoek")
    void definitieVanEenRechthoek() {
        String definitie = Rechthoek.geefDefinitie();
        assertEquals("Een rechthoek is een vierhoek met vier rechte hoeken.", definitie);
    }

    @Test
    @DisplayName("Oppervlak Default Rechthoek")
    void oppervlakDefaultRechthoek() {
        Rechthoek rechthoek = new Rechthoek();
        assertEquals(2, rechthoek.geefOppervlakte());
    }

    @Test
    @DisplayName("Oppervlak vierkant")
    void oppervlakVierkant() {
        Rechthoek rechthoek = new Rechthoek(2, 2);
        assertEquals(4, rechthoek.geefOppervlakte());
    }

    @Test
    @DisplayName("Oppervlak landscape rechthoek")
    void oppervlakLandscapeRechthoek() {
        Rechthoek rechthoek = new Rechthoek(2, 4, new Punt(1, 1), "groen");
        assertEquals(8, rechthoek.geefOppervlakte());
    }

    @Test
    @DisplayName("omtrek Default Rechthoek")
    void omtrekDefaultRechthoek() {
        Rechthoek rechthoek = new Rechthoek();
        assertEquals(6, rechthoek.geefOmtrek());
    }

    @Test
    @DisplayName("omtrek vierkant")
    void omtrekVierkant() {
        Rechthoek rechthoek = new Rechthoek(2, 2);
        assertEquals(8, rechthoek.geefOmtrek());
    }

    @Test
    @DisplayName("omtrek landscape rechthoek")
    void omtrekLandscapeRechthoek() {
        Rechthoek rechthoek = new Rechthoek(2, 4, new Punt(1, 1), "groen");
        assertEquals(12, rechthoek.geefOmtrek());
    }

    @Test
    @DisplayName("Groot figuur")
    void grootFiguur() {
        // Arrange
        Rechthoek rechthoek = new Rechthoek(11, 10);

        // Act(ivate)
        String grootte = rechthoek.vertelOverGrootte();

        // Assert
        assertEquals("Ik ben groot!!!", grootte);
    }

    @Test
    @DisplayName("Klein figuur")
    void kleinFiguur() {
        // Arrange
        Rechthoek rechthoek = new Rechthoek(9, 11);

        // Act(ivate)
        String grootte = rechthoek.vertelOverGrootte();

        // Assert
        assertEquals("Ik ben klein!!!", grootte);
    }
}