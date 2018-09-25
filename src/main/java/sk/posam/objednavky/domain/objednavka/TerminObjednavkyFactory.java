package sk.posam.objednavky.domain.objednavka;

import java.time.Duration;
import java.time.LocalTime;

/**
 * Factory objekt k termínom objednávok. Umožňuje vytvárať termín objednávky 
 * so štandardnou dĺžkou na 30 minút.
 */
public final class TerminObjednavkyFactory {
	
	private final static Duration STANDARDNA_DLZKA_OBJEDNAVKY_V_MINUTACH = Duration.ofMinutes( 30 );

	/**
	 * Metóda vytvorí termín objednávky pre danú hodinu a minútu
	 * so štandardnou dĺžkou pre termín objednávky.
	 */
	public static TerminObjednavky create( int hodina, int minuta ) {
		return new TerminObjednavky( LocalTime.of(hodina, minuta), STANDARDNA_DLZKA_OBJEDNAVKY_V_MINUTACH );
	}
	
	/**
	 * Pre daný termín objednávky vytvorí nasledujúci termín
	 * v nasledujúcom časovom intervale.
	 */
	public static TerminObjednavky createNext(TerminObjednavky result) {
		LocalTime cas = result.getCas();
		cas = cas.plus( STANDARDNA_DLZKA_OBJEDNAVKY_V_MINUTACH );
		return new TerminObjednavky( cas, STANDARDNA_DLZKA_OBJEDNAVKY_V_MINUTACH );
	}

	private TerminObjednavkyFactory() {
		// Na čo je tu tento konštruktor?
	}

	public static TerminObjednavky createZaciatokDna() {
		return new TerminObjednavky( LocalTime.of( 8, 0 ), STANDARDNA_DLZKA_OBJEDNAVKY_V_MINUTACH );
	}

}
