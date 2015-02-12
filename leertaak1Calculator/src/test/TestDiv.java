package test;

import junit.framework.TestCase;
import multiformat.Rational;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

/**
 * Created by Tanja on 12-2-2015.
 */
public class TestDiv extends TestCase{

    Rational s;
    Rational r;

    @Before
    public void setUp(){
        r = new Rational();
        s = new Rational();
    }

    public void testDiv() {

        r.setNumerator(12.5);
        s.setNumerator(0.0);
        r.setDenominator(1.0);
        s.setDenominator(0.0);
        try {
            r.div(s);
        } catch (Exception e) {
            e.printStackTrace();
        }

        r.setNumerator(12.5);
        s.setNumerator(8.0);
        r.setDenominator(0.01);
        s.setDenominator(10.5);
        try {
            s.div(r);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
