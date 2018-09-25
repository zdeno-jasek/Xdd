package sk.posam.objednavky.domain.objednavka;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.TemporalUnit;
import java.util.Formatter;

/**
 * Trieda drží základné informácie o termíne objednávky, t.j. presný čas objednávky
 * a dĺžku trvania objednávky. Termín objednávky neobsahuje informácie o dátume,
 * ale len o čase.
 */
public class TerminObjednavky {

	private LocalTime cas;
	private Duration dlzka;
	
	public TerminObjednavky(LocalTime cas, Duration dlzka) {
		this.cas = cas;
		this.dlzka = dlzka;
	}

	public Duration getDlzka() {
		return dlzka;
	}
	
	public LocalTime getCas() {
		return cas;
	}

	public boolean prekryvaSa(TerminObjednavky terminObjednavky) {
		LocalTime cas1Zaciatok = this.cas;
		LocalTime cas1Koniec = cas1Zaciatok.plus(this.dlzka);
		LocalTime cas2Zaciatok = terminObjednavky.cas;
		LocalTime cas2Koniec = cas2Zaciatok.plus(terminObjednavky.dlzka);
		// https://stackoverflow.com/a/17107966/146745
		return cas1Zaciatok.isBefore(cas2Koniec) && cas2Zaciatok.isBefore(cas1Koniec);
	}

}
