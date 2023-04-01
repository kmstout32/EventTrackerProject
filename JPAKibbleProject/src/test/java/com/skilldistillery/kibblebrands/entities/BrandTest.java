package com.skilldistillery.kibblebrands.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BrandTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Brand brand;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPAKibbleProject");

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();

	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		brand = em.find(Brand.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		brand = null;
	}

	@Test
	void test_brand_entity_mappings() {
		assertNotNull(brand);
		assertEquals("Purina", brand.getName());
	}
	@Test
	void test_brand_join_to_kibble_entity_mappings() {
		assertNotNull(brand);
		assertNotNull(brand.getKibbles());
		assertTrue( brand.getKibbles().size() > 0);
	}

}
