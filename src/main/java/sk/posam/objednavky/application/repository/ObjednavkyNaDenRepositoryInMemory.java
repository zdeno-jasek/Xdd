package sk.posam.objednavky.application.repository;

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
@Repository
final class ObjednavkyNaDenRepositoryInMemory implements ObjednavkyNaDenRepository {
	
	private final LocalDate dnes;
	private final Set<ObjednavkyNaDen> vsetkyObjednavky;
	
	ObjednavkyNaDenRepositoryInMemory() {
		dnes = LocalDate.now();
		vsetkyObjednavky = new HashSet<>();
		for (int i = 0; i < 5; i++) {
			vsetkyObjednavky.add( generujObjednavky( dnes.plusDays( i ) ) );
		}
	}

	@Override
	public ObjednavkyNaDen findByDatum( LocalDate den) {
		return vsetkyObjednavky.stream()
			.filter( objednavka -> objednavka.getDatum().equals(den) )
			.findFirst()
			.orElse( null );
	}
	
	/** Metóda poskytne vymyslené ukážkové dáta. */
	private ObjednavkyNaDen generujObjednavky( LocalDate den ) {
		ObjednavkyNaDen result = new ObjednavkyNaDen( den );
		result.objednaj( new Objednavka( new Osoba( "Albert", "Einstein" ), TerminObjednavkyFactory.create( 10, 00 ) ) );
		result.objednaj( new Objednavka( new Osoba( "Issac", "Newton" ), TerminObjednavkyFactory.create( 11, 00 ) ) );
		result.objednaj( new Objednavka( new Osoba( "Niels", "Bohr" ), TerminObjednavkyFactory.create( 12, 30 ) ) );
		
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
