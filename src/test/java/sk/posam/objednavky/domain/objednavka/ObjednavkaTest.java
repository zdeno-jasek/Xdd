package sk.posam.objednavky.domain.objednavka;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sk.posam.objednavky.domain.osoba.Osoba;

public class ObjednavkaTest {

	private TerminObjednavky terminObjednavky;
	private TerminObjednavky termin15_30;
	private TerminObjednavky termin10_30;
	private Osoba osoba;

	@Before
	public void setup() {
		osoba = new Osoba( "Albert", "Einstein" );
		terminObjednavky = TerminObjednavkyFactory.create(10, 30);
		termin15_30 = TerminObjednavkyFactory.create(15, 30);
		termin10_30 = TerminObjednavkyFactory.create(10, 30);
	}
	
	@Test
	public void testVTermine15_30jeVolno() {
		Objednavka objednavka = new Objednavka(osoba, terminObjednavky);
		
		assertFalse(	objednavka.terminJeObsadeny( termin15_30 ) );
	}

	@Test
	public void testVTermine10_30NieJeVolno() {
		Objednavka objednavka = new Objednavka(osoba, terminObjednavky);
		
		assertTrue(	objednavka.terminJeObsadeny( termin10_30 ) );
	}

}
