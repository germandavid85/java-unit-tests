package unit.tests.domain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CalculatorTest
{
    @Test
    public void sumTest() throws Exception
    {
        Calculator calc = new Calculator();

        assertEquals(calc.Calculate(1.0, 3.0, "+"), 4.0, 0.0);
    }

    @Test
    public void sumTestHamcrest() throws Exception
    {
        Calculator calc = new Calculator();

        // sugar
        assertThat(calc.Calculate(1.0, 3.0, "+"), equalTo(4.0));
        assertThat(calc.Calculate(1.0, 3.0, "+"), is(equalTo(4.0)));
        assertThat(calc.Calculate(1.0, 3.0, "+"), is(anything()));
        assertThat(calc.Calculate(1.0, 3.0, "+"), is(describedAs("invalid sum", equalTo(4.0))));

        // logical
        assertThat(calc.Calculate(1.0, 3.0, "+"), allOf(equalTo(4.0), greaterThanOrEqualTo(4.0), lessThanOrEqualTo(4.0)));

    }

    @Test
    public void subtractTest() throws Exception
    {
        Calculator calc = new Calculator();

        assertEquals(calc.Calculate(3.0, 1.0, "-"), 2.0, 0.0);
    }

    @Test
    public void divisionTest() throws Exception
    {
        Calculator calc = new Calculator();

        assertEquals(5.0, calc.Calculate(10.0, 2.0, "/"), 0.0);
    }

    @Test
    public void multiplicationTest() throws Exception
    {
        Calculator calc = new Calculator();

        assertEquals(20.0, calc.Calculate(10.0, 2.0, "*"), 0.0);
    }

    @Test
    public void divisionTestBoyZer() throws Exception
    {
        Calculator calc = new Calculator();

        assertThat(calc.Calculate(0.0, 0.0, "/"), is(equalTo(Double.NaN)));
    }
}
