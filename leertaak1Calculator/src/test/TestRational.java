package test;

import static org.junit.Assert.*;

import multiformat.Rational;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit Testcase to test Rational. 
 * Note that this class uses 'annotations' (the @...). This is a Java 1.5 feature. 
 * @author Niek and Tanja
 *
 */
public class TestRational {
	Rational r;
    Rational s;
	
	@Before
	public void setUp(){
		r = new Rational();
        s = new Rational();
	}


	@Test
    @Deprecated
	public void testSimplify() {
		r.setNumerator(25);
        s.setNumerator(5);
		r.setDenominator(5);
        s.setDenominator((4));
		r.simplify();
        s.simplify();
		

		
		r.setNumerator(10);
        s.setNumerator(14);
		r.setDenominator(0.5);
        s.setDenominator(5.5);
		r.simplify();
        s.simplify();
		

	}
	
	@Test
    @Deprecated
	public void testCanonical() {
		r.setNumerator(12.5);
        s.setNumerator(7.5);
		r.setDenominator(1.0);
        s.setDenominator(0);
		r.canonical();
        s.canonical();
        try {
            r.div(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            s.div(r);
        } catch (Exception e) {
            e.printStackTrace();
        }

        r.setNumerator(12.5);
		r.setDenominator(0.01);
		r.canonical();
		
	}
	
	@Test
    @Deprecated
	public void testCanonicalAndSimplify() {
		r.setNumerator(12.5);
		r.setDenominator(1.0);
		r.canonical();
		r.simplify();
		

	}



}
