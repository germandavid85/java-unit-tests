package unit.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest
{
    @Test
    public void shouldSum()
    {
        Calculator calc = new Calculator();

        assertEquals(calc.Calculate(1, 3, "+"), 4.0, 0.0);
    }
}
