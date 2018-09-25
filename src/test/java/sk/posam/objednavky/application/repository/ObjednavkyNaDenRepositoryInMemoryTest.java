package sk.posam.objednavky.application.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import sk.posam.objednavky.domain.objednavka.ObjednavkyNaDen;

public class ObjednavkyNaDenRepositoryInMemoryTest {
	private ObjednavkyNaDenRepositoryInMemory repository;
	
	@Before
	public void setUp() throws Exception {
		repository = new ObjednavkyNaDenRepositoryInMemory();
	}
	
	@Test
	public void testPrvyDenJeObjednany() {
		ObjednavkyNaDen objednavky = repository.findByDen( LocalDate.now() );
		assertNotNull(objednavky);
	}

	@Test
	public void testDruhyDenJeObjednany() {
		ObjednavkyNaDen objednavky = repository.findByDen( LocalDate.now().plusDays( 1 ) );
		assertNotNull(objednavky);
	}

	@Test
	public void testVceraNieJeObjednanyNikto() {
		ObjednavkyNaDen objednavky = repository.findByDen( LocalDate.now().plusDays( -1 ) );
		assertNull(objednavky);
	}

}
