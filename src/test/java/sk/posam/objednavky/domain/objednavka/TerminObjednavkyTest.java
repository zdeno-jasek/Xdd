package sk.posam.objednavky.domain.objednavka;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TerminObjednavkyTest {

	private TerminObjednavky terminObjednavky10_30;
	private TerminObjednavky terminObjednavky10_20;
	
	@Before
	public void setup() {
		terminObjednavky10_30 = TerminObjednavkyFactory.create( 10, 30);
		terminObjednavky10_20 = TerminObjednavkyFactory.create( 10, 20);
		
	}
	
	@Test
	public void testTerminObjednavky10_30saPrekryvaSObjednavkou10_20() {
		
		assertTrue( terminObjednavky10_20.prekryvaSa( terminObjednavky10_30 ) );
		assertTrue( terminObjednavky10_30.prekryvaSa( terminObjednavky10_20 ) );
		
	}

	@Test
	public void testTerminObjednavky10_30saNeprekryvaSObjednavkou15_20() {
		TerminObjednavky terminObjednavky10_30 = TerminObjednavkyFactory.create( 10, 30);
		TerminObjednavky terminObjednavky15_20 = TerminObjednavkyFactory.create( 15, 20);
		
		assertFalse( terminObjednavky15_20.prekryvaSa( terminObjednavky10_30 ) );
		assertFalse( terminObjednavky10_30.prekryvaSa( terminObjednavky15_20 ) );
		
	}

}
