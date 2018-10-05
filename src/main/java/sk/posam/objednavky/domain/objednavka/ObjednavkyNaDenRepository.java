package sk.posam.objednavky.domain.objednavka;

import java.time.LocalDate;

/**
 * Repository, ktoré drží všetky objednávky na daný deň.
 * Obsahuje "CRUD"-metódy na čítanie a zápis objednávok.
 */
public interface ObjednavkyNaDenRepository {

	/**
	 * Metóda vráti objednávku na daný deň.
	 */
	ObjednavkyNaDen findByDatum( LocalDate den );

	/**
	 * Metóda zapíše aktulizovanú objednávku do zoznamu.
	 */
	void update(ObjednavkyNaDen objednavky);

	void create(ObjednavkyNaDen objednavky);
	
}
