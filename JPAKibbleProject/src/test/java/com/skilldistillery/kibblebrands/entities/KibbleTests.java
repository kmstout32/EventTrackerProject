package com.skilldistillery.kibblebrands.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class KibbleTests {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Kibble kibble;
	
	@BeforeAll
	static void setUpBeforeTest() throws Exception{
		emf = Persistence.createEntityManagerFactory("JPAKibbleProject");
		
	}
	
	@AfterAll
	static void tearDownAfterTest() throws Exception{
		emf.close();
	}
	
	
	@BeforeEach
	void setUp1() throws Exception{
		em = emf.createEntityManager();
		kibble = em.find(Kibble.class, 1);
	}
	
	@AfterEach
	void tearDown() throws Exception{
		em.close();
		kibble = null;
		
		
	}
	@Test
	void test_kibble_entity() {
		assertNotNull(kibble);
		assertEquals("Purina One", kibble.getName());
	}
	
}
