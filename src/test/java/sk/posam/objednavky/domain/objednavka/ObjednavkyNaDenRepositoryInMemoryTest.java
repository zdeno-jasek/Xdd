package sk.posam.objednavky.domain.objednavka;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Repository;

import sk.posam.objednavky.domain.objednavka.Objednavka;
import sk.posam.objednavky.domain.objednavka.ObjednavkyNaDen;
import sk.posam.objednavky.domain.objednavka.ObjednavkyNaDenRepository;
import sk.posam.objednavky.domain.objednavka.TerminObjednavkyFactory;
import sk.posam.objednavky.domain.osoba.Osoba;

/**
 * Trieda poskytuje in-memory implementáciu pre repository.
 * Štandardná implementácia repository by využívala Hibernate query alebo
 * QueryDSL pre prístup k dátam a pre manipuláciu s nimi. 
 * Volala by sa napr. ObjednavkyNaDenRepositoryHibernate.
 * Technické časti riešenia však odsúvame bokom - toto by si mal vedieť každý predstaviť.
 * 
 * Treba si však všimnúť, že trieda nie je public, ale je final.
 */
final class ObjednavkyNaDenRepositoryInMemoryTest implements ObjednavkyNaDenRepository {
	
	private final LocalDate dnes;
	private final Set<ObjednavkyNaDen> vsetkyObjednavky;
	
	ObjednavkyNaDenRepositoryInMemoryTest() {
		dnes = LocalDate.now();
		vsetkyObjednavky = new HashSet<>();
		try {
			vsetkyObjednavky.add( generujObjednavky1( dnes.plusDays( 0 ) ) );
			vsetkyObjednavky.add( generujObjednavky2( dnes.plusDays( 1 ) ) );
			vsetkyObjednavky.add( generujObjednavky1( dnes.plusDays( 2 ) ) );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ObjednavkyNaDen findByDatum( LocalDate den) {
		return vsetkyObjednavky.stream()
			.filter( objednavka -> objednavka.getDatum().equals(den) )
			.findFirst()
			.orElse( null );
	}
	
	/** Metóda poskytne vymyslené ukážkové dáta. 
	 * @throws Exception */
	private ObjednavkyNaDen generujObjednavky1( LocalDate den ) throws Exception {
		int hodina = 8;
		ObjednavkyNaDen result = new ObjednavkyNaDen( den );
		result.objednaj( new Objednavka( new Osoba( "Albert", "Einstein" ), TerminObjednavkyFactory.create( hodina++, 00 ) ) );
		result.objednaj( new Objednavka( new Osoba( "Issac", "Newton" ), TerminObjednavkyFactory.create( hodina++, 00 ) ) );
		result.objednaj( new Objednavka( new Osoba( "Niels", "Bohr" ), TerminObjednavkyFactory.create( hodina++, 30 ) ) );
		
		return result;
	}

	private ObjednavkyNaDen generujObjednavky2( LocalDate den ) throws Exception {
		int hodina = 12;
		ObjednavkyNaDen result = new ObjednavkyNaDen( den );
		result.objednaj( new Objednavka( new Osoba( "Albert", "Einstein" ), TerminObjednavkyFactory.create( hodina++, 00 ) ) );
		result.objednaj( new Objednavka( new Osoba( "Issac", "Newton" ), TerminObjednavkyFactory.create( hodina++, 00 ) ) );
		result.objednaj( new Objednavka( new Osoba( "Niels", "Bohr" ), TerminObjednavkyFactory.create( hodina++, 30 ) ) );
		
		return result;
	}

	@Override
	public void update(ObjednavkyNaDen objednavky) {
		vsetkyObjednavky.add( objednavky );
	}

	@Override
	public void create(ObjednavkyNaDen objednavky) {
		vsetkyObjednavky.add( objednavky );
	}

}
