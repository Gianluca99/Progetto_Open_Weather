/**
 * Classe che si occupa dei test relativi alla classe ValoriStatistici
 * @author A.Goffi
 * @author G.Corso
 * */
package it.univpm.ProgettoGoffiCorso;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import it.univpm.ProgettoGoffiCorso.Stats.Stats;


class StatsTest {
	private Stats S = null;
	private Vector <Integer> v = new Vector<Integer>();
	@BeforeEach
	void setUp() throws Exception {
		v.add(0, 1010);
		v.add(1, 1020);
		S = new Stats();
		S.setMedia(v);
		S.setValoreMax(v);
		S.setValoreMin(v);
		S.setValoreQM(v);
		S.setVarianza(v);
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}
	
	/**
	 * Test 1 verifica i calcoli relativi alle statistiche
	 */
	
	@Test
	void test1() {
		assertEquals(1015, S.getMedia());
		assertEquals(1020, S.getValoreMax());
		assertEquals(1010, S.getValoreMin());
		assertEquals(1015.0123151962246, S.getValoreQM());
		assertEquals(50.0, S.getVarianza());
	}
	
	/**
	 * Test 2 verifica l'eccezione nel caso di vettore nullo in ingresso
	 */
	
	@Test
	void test2() {
		assertThrows(IllegalArgumentException.class, ()-> S.setValoreMax(null));
		assertThrows(IllegalArgumentException.class, ()-> S.setValoreMin(null));
		assertThrows(IllegalArgumentException.class, ()-> S.setVarianza(null));
		assertThrows(IllegalArgumentException.class, ()-> S.setMedia(null));
		assertThrows(IllegalArgumentException.class, ()-> S.setValoreQM(null));
	}

}
