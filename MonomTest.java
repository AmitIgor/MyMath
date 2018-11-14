package myMath;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MonomTest {

	@Test				// creating new Monom with a,b
	void test() {
		
		Monom mon = new Monom(2,4);
		String expected = "2.0x^4";
		
		assertEquals(expected, mon.toString());
	}

	@Test				// creating new Monom from existing Monom
	void test2() {
		
		Monom mon = new Monom(2,4);
		Monom mon2 = new Monom(mon);
		String expected = "2.0x^4";
		
		assertEquals(expected, mon2.toString());
	}

	@Test				// adding two Monoms, works only if they have the same power, otherwise, throws an exception we created ("monoms power are the same")
	void test3() {
		
		Monom m1 = new Monom(2,2);
		Monom m2 = new Monom(4,2);
		Monom expectedResult = new Monom (6,2);
		m1.add(m2);
		
		Monom_Comperator test = new Monom_Comperator();
		
		assertEquals(0, test.compare(expectedResult, m1));
	}
	
	@Test				// multiplying two Monoms
	void test4() {
		
		Monom m1 = new Monom(4,4);
		Monom m2 = new Monom(3,7);
		Monom expectedResult = new Monom(12,11); 
		Monom m3 = m1.multiply(m2);
		
		Monom_Comperator test = new Monom_Comperator();
		
		assertEquals(0, test.compare(expectedResult, m3));
	}

	@Test				// derivating a Monom
	void test5() {
		
		Monom m1 = new Monom(4,5);
		Monom expectedResult = new Monom(20,4);
		Monom m2 = m1.derivative();
		
		Monom_Comperator test = new Monom_Comperator();
		
		assertEquals(0, test.compare(expectedResult, m2));
	}

}
