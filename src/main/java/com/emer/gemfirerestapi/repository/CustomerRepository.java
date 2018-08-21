package com.emer.gemfirerestapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.emer.gemfirerestapi.model.Customer;

/**
 * 
 * @author Emerson Javid Gonzalez Morales
 *
 *Create simple queries
 *Spring Data GemFire focuses on storing data in GemFire.
 *It also inherits powerful functionality from the Spring Data Commons project, such as the ability to derive queries.
 *
 *@RepositoryRestResource is optional, it is used to redefine a default path.
 *
 *PersonRepository extends the CrudRepository interface and plugs in the type of values and keys it works with: Person and String. 
 *Out-of-the-box, this interface comes with many operations, including standard CRUD (create-read-update-delete).
 *
 *At runtime, Spring Data REST will create an implementation of this interface automatically. 
 *Then it will use the @RepositoryRestResource annotation to direct Spring MVC to create RESTful endpoints at /customer.
 */

@RepositoryRestResource(collectionResourceRel = "customer", path = "customer")
public interface CustomerRepository extends CrudRepository<Customer, Long>{
	Customer findByFirstName(@Param("firstName") String firstName);
	Customer findByLastName(@Param("lastName") String lastName);
	Iterable<Customer> findByAgeGreaterThan(@Param("age") int age);
	Iterable<Customer> findByAgeLessThan(@Param("age") int age);
	Iterable<Customer> findByAgeGreaterThanAndAgeLessThan(@Param("age") int age);
}
