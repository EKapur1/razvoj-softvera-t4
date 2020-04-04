package ba.unsa.etf.rs.tut4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RacunTest {

    @Test
    void test1() {
        Racun r = new Racun();
        r.dodajStavku(new Artikal("HLB", "Hljeb", 1.1), 2);
        r.dodajStavku(new Artikal("JAJ", "Jaje", 0.25), 5);
        assertEquals(3.45, r.ukupanIznos());
    }

    @Test
    void testPrazno() {
        Racun r = new Racun();
        assertEquals(0, r.ukupanIznos());
    }

    @Test
    void dodajStavku() {
        Racun r = new Racun();
        r.dodajStavku(new Artikal("HLB", "Hljeb", 1.1), 2);
        r.dodajStavku(new Artikal("HLB", "Hljeb", 1.1), 2);
        assertEquals(4.4, r.ukupanIznos());
    }

    @Test
    void ukupanIznos() {
        Racun r = new Racun();
        r.dodajStavku(new Artikal("HLB", "Hljeb", 1.1), 2);
        r.dodajStavku(new Artikal("HLB", "Hljeb", 1.1), 2);
        assertEquals(4.4, r.ukupanIznos());
    }

    @Test
    void testToString() {
        Racun r = new Racun();
        assertEquals("UKUPNO    0.0", r.toString());
        r.dodajStavku(new Artikal("HLB", "Hljeb", 1.1), 2);
        assertEquals("HLB   2.2\nUKUPNO    2.2", r.toString());
    }
}