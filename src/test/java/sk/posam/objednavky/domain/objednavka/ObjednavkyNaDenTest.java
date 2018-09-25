package sk.posam.objednavky.domain.objednavka;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import sk.posam.objednavky.domain.osoba.Osoba;

public class ObjednavkyNaDenTest {
	
	private LocalDate dnes;
	private ObjednavkyNaDen objednavkyNaDnes;

	@Before
	public void setup() {
		dnes = LocalDate.now();
		objednavkyNaDnes = new ObjednavkyNaDen( dnes );
		objednavkyNaDnes.objednaj( new Objednavka( new Osoba( "Albert", "Einstein" ), TerminObjednavkyFactory.create( 10, 00 ) ) );
		objednavkyNaDnes.objednaj( new Objednavka( new Osoba( "Issac", "Newton" ), TerminObjednavkyFactory.create( 11, 00 ) ) );
		objednavkyNaDnes.objednaj( new Objednavka( new Osoba( "Niels", "Bohr" ), TerminObjednavkyFactory.create( 12, 30 ) ) );
	}
	
	@Test
	public void test10_20NieJeVolno() {
		
		TerminObjednavky termin10_20 = TerminObjednavkyFactory.create(10, 20);
		assertFalse( objednavkyNaDnes.jeVolno( termin10_20 ) );
	}

	@Test
	public void test09_00JeVolno() {
		TerminObjednavky termin09_00 = TerminObjednavkyFactory.create(9, 00);
		assertTrue( objednavkyNaDnes.jeVolno( termin09_00 ) );
	}

}
