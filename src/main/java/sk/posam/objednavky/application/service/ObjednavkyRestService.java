package sk.posam.objednavky.application.service;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sk.posam.objednavky.domain.objednavka.ObjednavkyNaDen;
import sk.posam.objednavky.domain.objednavka.ObjednavkyNaDenRepository;
import sk.posam.objednavky.domain.objednavka.TerminObjednavky;
import sk.posam.objednavky.domain.objednavka.TerminObjednavkyFactory;

/**
 * Služba, ktorá implementuje restové API. Táto trieda neobsahuje žiadnu
 * doménovú logiku. Jej úlohou je spájať technologické časti s volaním
 * doménových častí. Na metódy tejto triedy nebudú písané unit-testy,
 * pretože nepotrebujeme testovať funkčnosť Oracle databázy, knižnice Hibernate,
 * Springu apod. 
 */
@RestController
@RequestMapping("/objednavka")
public class ObjednavkyRestService {

	@Autowired
	private ObjednavkyNaDenRepository repository;
	
	/**
	 * Metóda vráti objednávky na dnešný deň. Na jeden deň môže byť objednaných viacero osôb.
	 * Metóda môže vrátiť aj NULL, pokiaľ na dnešný deň neexistujú žiadne objednávky.
	 */
	// http://localhost:8080/objednavka/dnes
	@RequestMapping(method=RequestMethod.GET, value="dnes")
	public ObjednavkyNaDen dnesneObjednavky() {
		return repository.read( LocalDate.now() );
	}

	// http://localhost:8080/objednavka/volno?hodina=5&minuta=6
	@RequestMapping(method=RequestMethod.GET, value="volno")
	public boolean jeVolno( int hodina, int minuta ) {
		ObjednavkyNaDen objednavkyNaDen = repository.read( LocalDate.now() );
		TerminObjednavky termin = TerminObjednavkyFactory.create(hodina, minuta);
		return objednavkyNaDen.jeVolno(termin);
	}

	// http://localhost:8080/objednavka/objednanyKto?hodina=10&minuta=15
	@RequestMapping(method=RequestMethod.GET, value="objednanyKto")
	public String ktoJeObjednany( int hodina, int minuta ) {
		return "fakt neviem"; // TODO toto je bug, treba to fixnut
	}

	// http://localhost:8080/objednavka/objednanyKedy?meno="Niels"&priezvisko="Bohr"
	@RequestMapping(method=RequestMethod.GET, value="objednanyKedy")
	public LocalTime kedyJeObjednany( String meno, String priezvisko ) {
		return LocalTime.now(); // TODO toto je bug, treba to fixnut
	}
	
	// http://localhost:8080/objednavka
	@RequestMapping(method=RequestMethod.GET)
	public String hello() {
		return "hello";
	}

}
