package sk.posam.objednavky.domain.objednavka;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import sk.posam.objednavky.domain.osoba.Osoba;

/**
 * Aggregate Root, ktorý v sebe združuje všetky objednávky rôznych osôb na rovnaký deň.
 * Trieda drží invariant, že žiadne dve objednávky sa nesmú prekrývať.
 */
public class ObjednavkyNaDen {

	private LocalDate datum;
	private Collection<Objednavka> objednavky;
	
	public ObjednavkyNaDen( LocalDate datum ) {
		this.datum = datum;
		this.objednavky = new ArrayList<>();
	}
	
	/**
	 * Metóda zaregistruje novú objednávku na tento deň.
	 */
	public void objednaj( Objednavka objednavka ) {
		objednavky.add( objednavka );
	}

	public LocalDate getDatum() {
		return datum;
	}

	public Collection<Objednavka> getObjednavky() {
		return Collections.unmodifiableCollection( objednavky );
	}

	public boolean jeVolno(TerminObjednavky termin) {
		return ! objednavky.stream()
			.filter( objednavka -> objednavka.terminJeObsadeny(termin) )
			.findAny().isPresent();
	}

	public Objednavka objednaj( Osoba osoba ) {
		TerminObjednavky terminObjednavky = najdiVolnyTermin();
		Objednavka objednavka = new Objednavka(osoba, terminObjednavky);
		objednaj( objednavka );
		
		return objednavka;
	}

	private TerminObjednavky najdiVolnyTermin() {
		TerminObjednavky result = TerminObjednavkyFactory.createZaciatokDna();
		while ( ! jeVolno( result ) ) {
			result = TerminObjednavkyFactory.createNext( result );
		}
		return result;
	}
	
	public Optional<Objednavka> najdiOsobu(Osoba osoba) {
		return objednavky.stream()
		.filter( objednavka -> objednavka.getOsoba().equals(osoba) )
		.findFirst();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datum == null) ? 0 : datum.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ObjednavkyNaDen other = (ObjednavkyNaDen) obj;
		if (datum == null) {
			if (other.datum != null)
				return false;
		} else if (!datum.equals(other.datum))
			return false;
		return true;
	}

	
}
