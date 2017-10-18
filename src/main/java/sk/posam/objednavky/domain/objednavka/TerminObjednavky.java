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
	
}
