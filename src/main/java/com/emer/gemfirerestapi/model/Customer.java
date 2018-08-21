package com.emer.gemfirerestapi.model;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.gemfire.mapping.Region;

/**
 *
 * @author Emerson Javid Gonzalez Morales
 * 
 * Define a simple entity
 * GemFire is a data fabric. It maps data into regions, and it’s possible to configure distributed regions across multiple nodes. 
 * However, for this guide you use a local region so you don’t have to set up anything extra.
 *
 *@Region("customer") When GemFire stores the class, a new entry is created inside that specific region
 *
 *@Id This is for internal usage to help GemFire track the data
 *
 */

@Region("customer")
public class Customer {

	private static AtomicLong COUNTER = new AtomicLong(0L);
	
	@Id
	private long id;
	private String firstName;
	private String lastName;
	private int age;
	
	@PersistenceConstructor
	public Customer() {
		this.id = COUNTER.incrementAndGet();
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString(){
		return firstName +" "+ lastName + " is "+ age + " years old";
	}
}
