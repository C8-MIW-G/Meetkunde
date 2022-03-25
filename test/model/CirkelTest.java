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
}