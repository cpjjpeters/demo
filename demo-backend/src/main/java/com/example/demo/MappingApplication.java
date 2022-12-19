package com.example.demo;

import com.example.demo.city.persistence.jpa.CityJpaRepository;
import com.example.demo.city.persistence.jpa.entity.CityJpaEntity;
import com.example.demo.employee.persistence.entity.Employee;
import com.example.demo.employee.repository.EmployeeRepository;
import com.example.demo.instrument.persistence.jpa.InstrumentJpaRepository;
import com.example.demo.instrument.persistence.jpa.entity.InstrumentJpaEntity;
import com.example.demo.stad.persistance.entity.StadJpaEntity;
import com.example.demo.stad.repository.StadJpaPersistenceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class MappingApplication {

	public static void main(String[] args) {

		SpringApplication.run(MappingApplication.class, args);
	}


//	@Bean
//	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//		return args -> {
//
//			System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//			String[] beanNames = ctx.getBeanDefinitionNames();
//			Arrays.sort(beanNames);
//			for (String beanName : beanNames) {
//				System.out.println(beanName);
//			}
//
//		};
//	}


	@Autowired
	EmployeeRepository empRepo;


	@Autowired
	StadJpaPersistenceRepository stadRepository;

	@Autowired
	CityJpaRepository cityJpaRepository;

	@Autowired
	InstrumentJpaRepository instrumentJpaRepository;

	@Bean
	CommandLineRunner runner() {

		return args -> {
			InstrumentJpaEntity in1 = new InstrumentJpaEntity(1L,"AB InBev","BE0974293251","BRU","eur");
			InstrumentJpaEntity in2 = new InstrumentJpaEntity(2L,"Ahold Delhaize Koninklijke","NL0011794037","AEX","eur");
			InstrumentJpaEntity in3 = new InstrumentJpaEntity(3L,"Carrefour","FR0000120172","PAR","eur");
			instrumentJpaRepository.save(in1);
			instrumentJpaRepository.save(in2);
			instrumentJpaRepository.save(in3);
			StadJpaEntity stad1 = new StadJpaEntity("Antwerpen", 529247);
			StadJpaEntity stad2 = new StadJpaEntity("Brugge", 118656);
			StadJpaEntity stad3 = new StadJpaEntity("Luik", 197217);
			stadRepository.save(stad1);
			stadRepository.save(stad2);
			stadRepository.save(stad3);

			CityJpaEntity city1 = new CityJpaEntity("Gent", "grootstad","Oost-Vlaanderen",156.18, 264677);
			CityJpaEntity city2 = new CityJpaEntity("Waver", "kleine stad","Waals-Brabant",78.12, 33365);
			CityJpaEntity city3 = new CityJpaEntity("Bilzen", "kleine stad","Limburg",75.90,32477);
			CityJpaEntity city4 = new CityJpaEntity("Aalst", "centrumstad","Oost-Vlaanderen",78.12,88760);
			CityJpaEntity city5 = new CityJpaEntity("Blankenberge", "kuststad","West-Vlaanderen",17.41, 20399);
			CityJpaEntity city6 = new CityJpaEntity("Oostende", "centrumstad","West-Vlaanderen",37.72, 71489);
			cityJpaRepository.save(city1);
			cityJpaRepository.save(city2);
			cityJpaRepository.save(city3);
			cityJpaRepository.save(city4);
			cityJpaRepository.save(city5);
			cityJpaRepository.save(city6);
			Employee emp1 = new Employee("John", "Warton", "warton@gmail.com");
			Employee emp2 = new Employee("Mike", "Lanister", "lanister@gmail.com");
			Employee emp3 = new Employee("Steve", "Reeves", "Reeves@gmail.com");

			Employee emp4 = new Employee("Ronald", "Connor", "connor@gmail.com");
			Employee emp5 = new Employee("Jim", "Salvator", "Sal@gmail.com");
			Employee emp6 = new Employee("Peter", "Henley", "henley@gmail.com");

			Employee emp7 = new Employee("Richard", "Carson", "carson@gmail.com");
			Employee emp8 = new Employee("Honor", "Miles", "miles@gmail.com");
			Employee emp9 = new Employee("Tony", "Roggers", "roggers@gmail.com");

			// save employees in database

			empRepo.save(emp1);
			empRepo.save(emp2);
			empRepo.save(emp3);
			empRepo.save(emp4);
			empRepo.save(emp5);
			empRepo.save(emp6);
			empRepo.save(emp7);
			empRepo.save(emp8);
			empRepo.save(emp9);

		};

	}
}
