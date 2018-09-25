package sk.posam.objednavky.domain.objednavka;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

public class TerminObjednavkyFactoryTest {
	@Test
	public void testZa8_30nasleduje9_00() {
		TerminObjednavky termin0830 = TerminObjednavkyFactory.create( 8, 30);
		TerminObjednavky termin0900 = TerminObjednavkyFactory.createNext(termin0830);

		assertEquals( LocalTime.of( 9, 0),  termin0900.getCas() );
	}

}
