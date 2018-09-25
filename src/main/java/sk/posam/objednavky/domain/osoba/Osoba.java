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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((meno == null) ? 0 : meno.hashCode());
		result = prime * result + ((priezvisko == null) ? 0 : priezvisko.hashCode());
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
		Osoba other = (Osoba) obj;
		if (meno == null) {
			if (other.meno != null)
				return false;
		} else if (!meno.equals(other.meno))
			return false;
		if (priezvisko == null) {
			if (other.priezvisko != null)
				return false;
		} else if (!priezvisko.equals(other.priezvisko))
			return false;
		return true;
	}
	
}
