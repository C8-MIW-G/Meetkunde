package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CirkelTest {

    @Test
    void geefOmtrek() {
        // Arrange
        Cirkel cirkel = new Cirkel();

        // Act(ivate)
        double omtrek = cirkel.geefOmtrek();

        // Assert
        assertEquals(2 * Math.PI, omtrek);
    }

    @Test
    void geefOmtrekCustomStraal() {
        // Arrange
        Cirkel cirkel = new Cirkel(5);

        // Act(ivate)
        double omtrek = cirkel.geefOmtrek();

        // Assert
        assertEquals(2 * Math.PI * 5, omtrek);
    }

    @Test
    @DisplayName("Geef omtrek all-args constructor")
    void geefOmtrekAllArgsConstructor() {
        // Arrange
        Cirkel cirkel = new Cirkel(2.5, 1, 4, "paars");

        // Act(ivate)
        double omtrek = cirkel.geefOmtrek();

        // Assert
        assertEquals(2 * Math.PI * 2.5, omtrek);
    }

    @Test
    @DisplayName("Oppervlak met eenheidscirkel")
    void oppervlakMetEenheidscirkel() {
        // Arrange
        Cirkel cirkel = new Cirkel();

        // Act(ivate)
        double oppervlak = cirkel.geefOppervlakte();

        // Assert
        assertEquals(Math.PI, oppervlak);
    }

    @Test
    @DisplayName("Definitie van een Cirkel")
    void definitieVanEenCirkel() {
        String definitie = Cirkel.geefDefinitie();
        assertEquals("Een cirkel is een verzameling punten, die allemaal dezelfde\n" +
                "afstand tot een middelpunt hebben.", definitie);
    }

    @Test
    @DisplayName("Aanpassen straal naar negatief nummer mag niet werken")
    void aanpassenStraalNaarNegatiefNummerMagNietWerken() {
        // Arrange
        Cirkel cirkel = new Cirkel();
        double straal = -1;

        // Act(ivate)
        cirkel.setStraal(straal);

        // Assert
        assertNotEquals(straal, cirkel.getStraal());
    }

    @Test
    @DisplayName("Straal aanpassen naar geldige nieuwe straal")
    void straalAanpassenNaarGeldigeNieuweStraal() {
        // Arrange
        Cirkel cirkel = new Cirkel(5);
        double straal = 8;

        // Act(ivate)
        cirkel.setStraal(straal);

        // Assert
        assertEquals(straal, cirkel.getStraal());
    }

    @Test
    @DisplayName("Groot figuur")
    void grootFiguur() {
        // Arrange
        Cirkel cirkel = new Cirkel(6);

        // Act(ivate)
        String grootte = cirkel.vertelOverGrootte();

        // Assert
        assertEquals("Ik ben groot!!!", grootte);
    }

    @Test
    @DisplayName("Klein figuur")
    void kleinFiguur() {
        // Arrange
        Cirkel cirkel = new Cirkel(5);

        // Act(ivate)
        String grootte = cirkel.vertelOverGrootte();

        // Assert
        assertEquals("Ik ben klein!!!", grootte);
    }

    @Test
    @DisplayName("constructor aanroepen met negatieve straal")
    void constructorAanroepenMetNegatieveStraal() {
        // Arrange
        Cirkel cirkel = new Cirkel(-1);

        // Act(ivate)

        // Assert
        assertNotEquals(-1, cirkel.getStraal());
    }
}