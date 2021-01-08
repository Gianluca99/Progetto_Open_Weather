/**
 * CLasse che si occupa dei test
 * @author A.Goffi, G.Corso
 */
package it.univpm.ProgettoGoffiCorso;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class Test {
	private Input i;
	@BeforeEach
	void setUp() throws Exception {
		i = new Input("ancona", "2021/1/3");
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	/**
	 * Test 1 verifica la corretta assegnazione dei valori di input quali città e data
	 */
	
	@org.junit.jupiter.api.Test
	void test() {
		assertEquals("ancona", i.getNome());
		assertEquals("2021/1/3", i.getData());
	}

	/**
	 * Test 2 verifica l'eccezione nel caso di inserimento di una stringa vuota nel nome della città
	 */
	
	@org.junit.jupiter.api.Test
	void test1() {
		assertThrows(IllegalArgumentException.class, ()-> i.setNome(""));
	}
	
	/**
	 * Test 3 verifica l'eccezione nel caso di inserimento di una stringa vuota nella data
	 */
	
	@org.junit.jupiter.api.Test
	void test2() {
		assertThrows(IllegalArgumentException.class, ()-> i.setData(""));
	}

}