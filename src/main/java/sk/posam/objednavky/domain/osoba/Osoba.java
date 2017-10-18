package sk.posam.objednavky.domain.osoba;

/**
 * Trieda zastrešuje informácie o osobe, ktoré sú potrebné v objednávkovom systéme.
 * Osoba nie je kľúčovou triedou v doméne, ale doména sa bez nej nezaobíde.
 * Preto je umiestnená v osobitnom module.
 */
public class Osoba {

	private String meno;
	private String priezvisko;
	
	public Osoba(String meno, String priezvisko) {
		this.meno = meno;
		this.priezvisko = priezvisko;
	}

	public String getMeno() {
		return meno;
	}
	public String getPriezvisko() {
		return priezvisko;
	}

}
