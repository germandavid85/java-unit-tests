package unit.tests;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

public class CalculatorTest
{
    // junit 4
    // @Rule
    // public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void sumTest() throws Exception
    {
        Calculator calc = new Calculator();

        assertEquals(calc.Calculate(1, 3, "+"), 4.0, 0.0);
    }

    @Test
    public void sumTestHamcrest() throws Exception
    {
        Calculator calc = new Calculator();

        // sugar
        assertThat(calc.Calculate(1, 3, "+"), equalTo(4.0));
        assertThat(calc.Calculate(1, 3, "+"), is(equalTo(4.0)));
        assertThat(calc.Calculate(1, 3, "+"), is(anything()));
        assertThat(calc.Calculate(1, 3, "+"), is(describedAs("invalid sum", equalTo(4.0))));

        // logical
        assertThat(calc.Calculate(1, 3, "+"), allOf(equalTo(4.0), greaterThanOrEqualTo(4.0), lessThanOrEqualTo(4.0)));

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

    // @Test
    // public void zeroDivisionTestCase1() throws Exception
    // {
    //     Calculator calc = new Calculator();

    //     try {
    //         calc.Calculate(10, 0, "/");
    //     } catch (Exception e) {
    //         assertEquals("java.lang.ArithmeticException: / by zero", e.toString());
    //     }
    // }

    // junit 4
    // @Test(expected = ArithmeticException.class)
    // public void zeroDivisionTestCase1() throws Exception
    // {
    //     Calculator calc = new Calculator();
    //     calc.Calculate(10, 0, "/");
    // }

    // junit 4
    // @Test
    // public void zeroDivision1() {
    //     exceptionRule.expect(NumberFormatException.class);
    //     exceptionRule.expectMessage("For input string");
    //     Integer.parseInt("1a");
    // }

    @Test
    public void zeroDivision() throws Exception
    {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            Calculator calc = new Calculator();
            calc.Calculate(10, 0, "/");
        });

        String expectedMessage = "/ by zero";
        String actualMessage = exception.getMessage();

        assertEquals(actualMessage, expectedMessage);
    }
}
