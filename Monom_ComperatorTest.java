package myMath;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Monom_ComperatorTest {
	
	Monom m1 = new Monom(2, 2);
	Monom m2 = new Monom(2, 3);
	Monom m3 = new Monom(m1);

	@Test				// if m1<m2 --> -1
	void test() {			
		
		Monom_Comperator test = new Monom_Comperator();
		int output = test.compare(m1, m2);
		
		assertEquals(-1, output);
	}

	@Test				// if m1>m2 --> 1
	void test2() {
		
		Monom_Comperator test = new Monom_Comperator();
		int output = test.compare(m2, m1);
		
		assertEquals(1, output);
	}
	
	@Test				// if m1=m2 --> 0
	void test3() {
		
		Monom_Comperator test = new Monom_Comperator();
		int output = test.compare(m1, m3);
		
		assertEquals(0, output);
	}
}
