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
	
	@org.junit.jupiter.api.Test
	void test() {
		assertEquals("ancona", i.getNome());
		assertEquals("2021/1/3", i.getData());
	}

	@org.junit.jupiter.api.Test
	void test1() {
		assertThrows(IllegalArgumentException.class, ()-> i.setNome(""));
	}
	
	@org.junit.jupiter.api.Test
	void test2() {
		assertThrows(IllegalArgumentException.class, ()-> i.setData(""));
	}

}