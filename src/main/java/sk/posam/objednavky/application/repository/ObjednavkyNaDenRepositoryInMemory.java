package sk.posam.objednavky.application.repository;

import java.time.LocalDate;

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
	
	private LocalDate dnes;
	private ObjednavkyNaDen objednavkyNaDnes;

	@Override
	public ObjednavkyNaDen read( LocalDate den) {
		return singleton();
	}
	
	/** Metóda poskytne vymyslené ukážkové dáta. */
	private ObjednavkyNaDen singleton() {
		if ( objednavkyNaDnes == null ) {
			dnes = LocalDate.now();
			objednavkyNaDnes = new ObjednavkyNaDen( dnes );
			objednavkyNaDnes.objednaj( new Objednavka( new Osoba( "Albert", "Einstein" ), TerminObjednavkyFactory.create( 10, 00 ) ) );
			objednavkyNaDnes.objednaj( new Objednavka(new Osoba( "Issac", "Newton" ), TerminObjednavkyFactory.create( 11, 00 ) ) );
			objednavkyNaDnes.objednaj( new Objednavka( new Osoba( "Niels", "Bohr" ), TerminObjednavkyFactory.create( 12, 30 ) ) );
		}
		return objednavkyNaDnes;
	}

}
