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

import it.univpm.ProgettoGoffiCorso.Stats.ValoriStatistici;

class ValoriStatisticiTest {
	private ValoriStatistici VS = null;
	private Vector <Integer> v = new Vector<Integer>();
	@BeforeEach
	void setUp() throws Exception {
		v.add(0, 1010);
		v.add(1, 1020);
		VS = new ValoriStatistici(v);
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}
	
	/**
	 * Test 1 verifica i calcoli relativi alle statistiche
	 */
	
	@Test
	void test1() {
		assertEquals(1015, VS.getMedia());
		assertEquals(1020, VS.getValoreMax());
		assertEquals(1010, VS.getValoreMin());
		assertEquals(1015.0123151962246, VS.getValoreQM());
		assertEquals(50.0, VS.getVarianza());
	}
	
	/**
	 * Test 2 verifica l'eccezione nel caso di vettore nullo in ingresso
	 */
	
	@Test
	void test2() {
		assertThrows(IllegalArgumentException.class, ()-> VS.setValoreMax(null));
		assertThrows(IllegalArgumentException.class, ()-> VS.setValoreMin(null));
		assertThrows(IllegalArgumentException.class, ()-> VS.setVarianza(null));
		assertThrows(IllegalArgumentException.class, ()-> VS.setMedia(null));
		assertThrows(IllegalArgumentException.class, ()-> VS.setValoreQuadraticoMedio(null));
	}

}
