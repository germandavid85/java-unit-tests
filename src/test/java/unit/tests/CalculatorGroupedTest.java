package unit.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Calculator nested tests")
public class CalculatorGroupedTest {
    private Calculator calc = new Calculator();

    @Nested
    class SumOperation {
        @DisplayName("Sum negatives")
        @Test
        public void negativeNumbersCanBeSummed() throws Exception {
            assertThat(calc.Calculate(-1.0, -3.0, "+"), equalTo(-4.0));
        }
    }

    @Nested
    class SubtractOperation {
        @DisplayName("Subtract negatives")
        @Test
        public void negativeNumbersCanBeSubtracted() throws Exception {
            assertThat(calc.Calculate(-1.0, -3.0, "-"), equalTo(2.0));
        }

        @Nested
        class SubtractPositives {
            @DisplayName("Subtract positives")
            @Test
            public void positiveNumbersCanBeSubtracted() throws Exception {
                assertThat(calc.Calculate(1.0, 3.0, "-"), equalTo(-2.0));
            }
        }
    }
}
