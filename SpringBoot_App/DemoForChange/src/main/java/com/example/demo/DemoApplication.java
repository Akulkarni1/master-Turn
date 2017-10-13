package com.example.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class DemoApplication {
	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(EmployeeRepository repository,EmployeeHeatRepository re) {
		return (args) -> {
			// save a couple of customers
		repository.save(new Employee(Long.parseLong("2312"), "Amit K", 130000, "E"));
			repository.save(new Employee(Long.parseLong("2313"), "Adi R", 160000, "D"));
			repository.save(new Employee(Long.parseLong("2314"), "Shlomi V", 140000, "G"));
			repository.save(new Employee(Long.parseLong("2315"), "Marina V", 145000, "M"));
			
			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Employee emp : repository.findAll()) {
				log.info(emp.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Employee em = null; 
			
			try{
				 em = repository.findOne(2315L);
				 //EmployeeHeat e ;
				 //log.info("em has the value "+em.toString());
				 if(em==null) {
					
					 
				//repository.save(new Employee(Long.parseLong("2315"), "Itsik I", 150000, "M"));
				 re.save(new EmployeeHeat(Long.parseLong("2315"), "Itsik I", 150000, "M",true));
					log.info("Customer found with findOne(2315L):");
					log.info("--------------------------------");
					//log.info(em.toString());
					for (EmployeeHeat bauer : re.findByName("Itsik I")) {
						log.info(bauer.toString());
					}
					log.info("");
				 }
				
				 
			}
			catch(NullPointerException ne) {
				System.out.println(ne);
					
			}
			
			
			// fetch all customers
						log.info("Customers found with findAll():");
						log.info("-------------------------------");
						for (Employee employee1 : repository.findAll()) {
							log.info(employee1.toString());
						}
						log.info("");
			
			// fetch customers by last name
			log.info("Customer found with findByLastName('Adi'):");
			log.info("--------------------------------------------");
			for (Employee bauer : repository.findByName("Adi R")) {
				log.info(bauer.toString());
			}
			log.info("");
		};
	}

}