package com.emer.gemfirerestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

/**
 * 
 * @author Emerson Javid Gonzalez Morales
 * 
 * @EnableGemfireRepositories enable GemfireRepositories
 * will scan the current package for any interfaces that extend one of Spring Data’s repository interfaces.
 * Use it’s basePackageClasses=MyRepository.class to safely tell Spring Data GemFire to scan a different root package by type.
 *
 *The application autowires an instance of PersonRepository that you just defined. 
 *Spring Data GemFire will dynamically create a concrete class that implements that 
 *interface and will plug in the needed query code to meet the interface’s obligations. 
 *This repository instance is the used by the run() method to demonstrate the functionality.
 */

@SpringBootApplication
@EnableGemfireRepositories
public class SpringBootGemfireRestfulApiApplication {	
	/**
	 * 
	 * @param args
	 * The public static void main uses Spring Boot’s SpringApplication.run() to launch the application and invoke the CommandLineRunner that builds the relationships.
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringBootGemfireRestfulApiApplication.class, args);
	}

}
