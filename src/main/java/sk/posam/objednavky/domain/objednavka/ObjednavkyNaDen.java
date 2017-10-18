package sk.posam.objednavky.domain.objednavka;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

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
	
}
