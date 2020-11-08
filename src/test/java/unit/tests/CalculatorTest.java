package unit.tests;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest
{
    @Test
    public void sumTest() throws Exception
    {
        Calculator calc = new Calculator();

        assertEquals(calc.Calculate(1, 3, "+"), 4.0, 0.0);
    }

    @Test
    public void sumTestTrue() throws Exception
    {
        Calculator calc = new Calculator();

        assertTrue(calc.Calculate(1, 3, "+") == 4.0);
    }

    @Test
    public void subtractTest() throws Exception
    {
        Calculator calc = new Calculator();

        assertEquals(calc.Calculate(3, 1, "-"), 2.0, 0.0);
    }

    @Test
    public void divisionTest() throws Exception
    {
        Calculator calc = new Calculator();

        assertEquals(5.0, calc.Calculate(10, 2, "/"), 0.0);
    }

    @Test
    public void multiplicationTest() throws Exception
    {
        Calculator calc = new Calculator();

        assertEquals(20.0, calc.Calculate(10, 2, "*"), 0.0);
    }

    @Test
    public void zeroDivisionTestCase1() throws Exception
    {
        Calculator calc = new Calculator();

        try {
            calc.Calculate(10, 0, "/");
        } catch (Exception e) {
            assertEquals("java.lang.ArithmeticException: / by zero", e.toString());
        }
    }
}
