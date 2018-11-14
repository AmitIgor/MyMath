package myMath;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PolynomTest {

	@Test					// creating an empty Polynom
	void test() {
		
		Polynom pol = new Polynom();
		String expected = "0x^0";
		
		assertEquals(expected, pol.toString());
	}

	@Test					// creating a Polynom using a string
	void test2() {
		
		Polynom pol = new Polynom("2x^2+4x^4-5");
		Polynom pol2 = new Polynom();
		pol2.add(new Monom(2,2));
		pol2.add(new Monom(4,4));
		pol2.add(new Monom(-5,0));
		
		assertTrue(pol2.equals(pol));
	}

	@Test					// creating a Polynom using a copy constructor
	void test3() {
		
		Polynom pol = new Polynom("2x^2+4x^4-5");
		Polynom_able pol2 = new Polynom();
		pol2 = pol.copy();
		
		assertFalse(pol == pol2);				// shows that they have different adresses, hence not the same object
		assertTrue(pol.equals(pol2));			// data is equal
		
	}

	@Test					// adding a Monom to Polynom 
	void test4() {
		
		Polynom pol = new Polynom("2x + 4x^2");
		pol.add(new Monom(4,4));
		
		Polynom pol2 = new Polynom("2x + 4x^2 +4x^4");
		
		assertTrue(pol.equals(pol2));
	}

	@Test					// adding one Polynom to another
	void test5() {			
		
		Polynom pol = new Polynom("2x + 4x^2");
		pol.add(pol);
		
		Polynom pol2 = new Polynom("4x + 8x^2");
		
		assertTrue(pol.equals(pol2));
	}

	@Test					// substracting one Polynom from another
	void test6() {
		
		Polynom pol = new Polynom("2x + 4x^2");
		Polynom pol2 = new Polynom("4x + 8x^2");
		pol.substract(pol2);
		
		Polynom pol3 = new Polynom("-2x - 4x^2");
		
		assertTrue(pol.equals(pol3));
	}

	@Test					// multiplying one Polinom with another
	void test7() {
		Polynom pol = new Polynom("x + 5x^2 -3");
		Polynom pol2 = new Polynom("2x + 4");
		pol.multiply(pol2);
		
		Polynom pol3 = new Polynom("10x^3 +22x^2 -2x -12");
		
		assertTrue(pol.equals(pol3));
		
	}

	@Test					// finding a root of a Polynom in a certain range [a,b]
	void test8() {
		Polynom pol = new Polynom("x^2 + 7x + 6");						// X1,X2 = -1, -6
		
		assertEquals(-1, pol.root(-3, 3, Double.MIN_NORMAL));
		assertEquals(-6, pol.root(-6, -1, Double.MIN_NORMAL));
	}
	
	@Test					// finding a root of a Polynom of higher degree than 2, in a certain range [a,b]
	void test9() {
		Polynom pol = new Polynom("1x^5 - 5x^4 + 2x^3 + 14x^2 - 3x^1 - 9x^0");				// X1,X2,X3 = -1, 1, 3
		
		assertEquals(3, pol.root(0, 3, Double.MIN_NORMAL));
		assertEquals(1, pol.root(0, 5, Double.MIN_NORMAL));
		assertEquals(3, pol.root(1.1, 3, Double.MIN_NORMAL));
		assertEquals(-1, pol.root(-6, -1, Double.MIN_NORMAL));
	}
	
}
