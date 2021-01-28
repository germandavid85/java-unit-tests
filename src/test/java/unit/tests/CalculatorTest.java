package unit.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import unit.tests.extensions.ConfigureCalculatorTest;
@ConfigureCalculatorTest
public class CalculatorTest {
    private Calculator calculator;

    public CalculatorTest(final Calculator calculator) {
        this.calculator = calculator;
    }

    @Test
    public void sumTest() throws Exception {
        assertEquals(calculator.Calculate(1.0, 3.0, "+"), 4.0, 0.0);
    }

    @Test
    public void sumTestHamcrest() throws Exception {
        // sugar
        assertThat(calculator.Calculate(1.0, 3.0, "+"), equalTo(4.0));
        assertThat(calculator.Calculate(1.0, 3.0, "+"), is(equalTo(4.0)));
        assertThat(calculator.Calculate(1.0, 3.0, "+"), is(anything()));
        assertThat(calculator.Calculate(1.0, 3.0, "+"), is(describedAs("invalid sum", equalTo(4.0))));

        // logical
        assertThat(calculator.Calculate(1.0, 3.0, "+"), allOf(equalTo(4.0), greaterThanOrEqualTo(4.0), lessThanOrEqualTo(4.0)));

    }

    @Test
    public void subtractTest() throws Exception {
        assertEquals(calculator.Calculate(3.0, 1.0, "-"), 2.0, 0.0);
    }

    @Test
    public void divisionTest() throws Exception {
        assertEquals(5.0, calculator.Calculate(10.0, 2.0, "/"), 0.0);
    }

    @Test
    public void multiplicationTest() throws Exception {
        assertEquals(20.0, calculator.Calculate(10.0, 2.0, "*"), 0.0);
    }

    @Test
    public void divisionTestBoyZer() throws Exception {
        assertThat(calculator.Calculate(0.0, 0.0, "/"), is(equalTo(Double.NaN)));
    }
}
