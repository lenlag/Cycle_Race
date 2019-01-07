package formation.afpa.fr;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import formation.afpa.fr.entity.Country;
import formation.afpa.fr.entity.Cycle;
import formation.afpa.fr.entity.Location;
import formation.afpa.fr.entity.Person;
import formation.afpa.fr.repository.CountryRepository;
import formation.afpa.fr.repository.CycleRepository;
import formation.afpa.fr.repository.LocationRepository;
import formation.afpa.fr.repository.PersonRepository;
import formation.afpa.fr.repository.RaceRepository;
import formation.afpa.fr.repository.RacerRepository;
import formation.afpa.fr.repository.TeamRepository;


@SpringBootApplication
public class ExCycleRaceApplication implements CommandLineRunner {
	
	private static Log log = LogFactory.getLog(ExCycleRaceApplication.class);
	
	@Autowired
	CountryRepository countryRep;
	
	@Autowired
	CycleRepository cycleRep;
	
	@Autowired
	LocationRepository locRep;
	
	@Autowired
	PersonRepository persRep;
	
	@Autowired
	RaceRepository raceRep;
	
	@Autowired
	RacerRepository racerRep;
	
	@Autowired
	TeamRepository teamRep;
	
	

	public static void main(String[] args) {
		SpringApplication.run(ExCycleRaceApplication.class, args);
	}

	@Transactional	//used here to create a temporary Session when the entities are in LAZY mode
	public void run(String... args) throws Exception {
		
		initBDD();
		
	}
	
	private void initBDD() {
		log.info("coucou");
		
		Country russia = new Country(null, "Russia", "RU");
		Country france = new Country(null, "France", "FR");
		Country italy = new Country(null, "Italy", "IT");
		Country spain = new Country(null, "Spain", "SP");
		
		countryRep.save(russia);
		countryRep.save(france);
		countryRep.save(italy);
		countryRep.save(spain);
				
		Location locRus = new Location(null, "Saint Petersburg", russia);
		Location locFr = new Location(null, "Lyon", france);
		Location locIt = new Location(null, "Milan", italy);
		Location locSp = new Location(null, "Ronda", spain);
		locRep.save(locRus);
		locRep.save(locFr);
		locRep.save(locIt);
		locRep.save(locSp);
		
		Cycle cycleFroome = new Cycle(null, "KTM", "KHH552", 7, 3);
		Cycle cycleRowe = new Cycle(null, "BMC", "SRL01", 8, 3);
		Cycle cycleUran = new Cycle(null, "Merida", "E120", 6, 3);
		Cycle cycleBardet = new Cycle(null, "Kuota", "Khan", 5, 2);
		Cycle cycleDomont = new Cycle(null, "Canyon", "Aeroad", 6, 2);
		
		cycleRep.save(cycleFroome);
		cycleRep.save(cycleRowe);
		cycleRep.save(cycleUran);
		cycleRep.save(cycleBardet);
		cycleRep.save(cycleDomont);
		
		Person froome = new Person(null, "Chris", "Froome");
		Person rowe = new Person(null, "Luke", "Rowe");
		Person uran = new Person(null, "Rigoberto", "Uran");
		Person bardet = new Person(null, "Romain", "Bardet");
		Person domont = new Person(null, "Axel", "Domont");
		
		persRep.save(froome);
		persRep.save(rowe);
		persRep.save(uran);
		persRep.save(bardet);
		persRep.save(domont);
		
		
		
		
	}

}

