package sk.posam.objednavky.domain.objednavka;

import sk.posam.objednavky.domain.osoba.Osoba;

/**
 * Entity object Objednavka spája osobu s termínom objednávky.
 * Termín objednávky je však iba časový údaj, takže objednávka sama
 * nevie povedať, na ktorý deň sa vzťahuje. Tento kontext jej dáva
 * objekt ObjednavkyNaDen.
 */
public class Objednavka {

	/** Termín objednávky obsahuje čas a aj dĺžku trvania. */
	private TerminObjednavky terminObjednavky;
	/** Osoba, ktorá je na daný deň objednaná. */
	private Osoba osoba;
	
	public Objednavka( Osoba osoba, TerminObjednavky terminObjednavky) {
		this.osoba = osoba;
		this.terminObjednavky = terminObjednavky;
	}

	public TerminObjednavky getTerminObjednavky() {
		return terminObjednavky;
	}
	
	public Osoba getOsoba() {
		return osoba;
	}
	
}
