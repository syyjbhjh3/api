package com.jpa.api;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SpringBootApplication
public class ApiApplication {
	public static void main(String[] args) {
		//SpringApplication.run(ApiApplication.class, args);
		EntityManagerFactory emf =  Persistence.createEntityManagerFactory("practice");
		EntityManager em = emf.createEntityManager();

		em.close();
		emf.close();
	}
}
