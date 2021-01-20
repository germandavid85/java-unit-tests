package unit.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.stream.Stream;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SmellsTest
{
    Calculator calc = new Calculator();

    // multiple assertions in a single test should be avoided but if they have to be used make sure a message is added
    @Test
    public void multipleAssertionsWithoutMessage() throws Exception {
        assertThat("invalid sum", calc.Calculate(1.0, 0.0, "+"), is(equalTo(1.0)));
        assertThat("invalid subract", calc.Calculate(1.0, 0.0, "-"), is(equalTo(-1.0)));
    }

    // avoid conditionals of any logic in the test, this case must be two separate cases
    @ParameterizedTest
    @MethodSource("calculatorProvider")
    public void logicInTest(double first, double second, String operator, double expected) throws Exception {
        Calculator calc = new Calculator();

        if (operator == "sum") {
            assertThat(calc.Calculate(first, second, "+"), is(equalTo(expected)));
        } else if (operator == "sub") {
            assertThat(calc.Calculate(first, second, "-"), is(equalTo(expected)));
        }
    }

    // this should be 3 separate methods or use parametrized tests
    @Test
    public void multipleAssertions() throws Exception {
        assertThat("invalid sum", calc.Calculate(-1.0, 4.5, "+"), is(equalTo(3.5)));
        assertThat("invalid sum", calc.Calculate(1.0, -4.5, "+"), is(equalTo(-3.5)));
        assertThat("invalid sum", calc.Calculate(0.0, 0.0, "+"), is(equalTo(0.0)));
    }

    // unit test should not create a flow take the outputs from one method as inputs of the next one
    @Test
    public void testingFlow() throws Exception {
        Double sumResult = calc.Calculate(-1.0, 4.5, "+");

        assertThat("invalid sum", sumResult, is(equalTo(3.5)));

        Double subractionResult = calc.Calculate(sumResult, 1.0, "-");

        assertThat("invalid sum", subractionResult, is(equalTo(2.5)));
    }

    // this dummy tests must be avoided, like true == true, 0.0 == 0.0
    @Test
    public void imAddingCoverage() throws Exception {
        calc.Calculate(-1.0, 4.5, "+");

        assertThat("invalid sum", true, is(equalTo(true)));
    }

    // use junit built in functionality to test exceptions
    @Test
    public void manuallyHandling() throws Exception {
        Calculator calc = new Calculator();

        try {
            calc.Calculate(10.0, 0.0, "foo");
        } catch (Exception e) {
            assertThat(e.toString(), is(equalTo("java.lang.Exception: invalid operator")));
        }
    }

    // remove any print in test functions, the output should be given by the reports
    @Test
    public void printMe() throws Exception {
        Double sumResult = calc.Calculate(-1.0, 4.5, "+");

        System.out.println("sum result is: " + sumResult);

        assertThat("invalid sum", sumResult, is(equalTo(3.5)));
    }

    // any async process should be mocked, like a process that takes some seconds or the time could be mocked too
    @Test
    public void imPausing() throws Exception {
        Double sumResult = calc.Calculate(-1.0, 4.5, "+");

        Thread.sleep(1000);

        assertThat("invalid sum", sumResult, is(equalTo(3.5)));
    }

    // sum method must be private within Calculator class, avoid exposing private funtions and prefer refactors
    @Test
    public void imExposingAPrivateMethodJustForTesting() throws Exception {
        Double sumResult = calc.sum(-1.0, 4.5);

        assertThat("invalid sum", sumResult, is(equalTo(3.5)));
    }

    // using the same logic as the tested one does not add value to the test, exceptions could be testing oracles
    @Test
    public void imReimplementingTheLogicJustToTestIt() throws Exception {
        Double sumResult = calc.Calculate(-1.0, 4.5, "+");
        Double expected = -1.0 + 4.5;

        assertThat("invalid sum", sumResult, is(equalTo(expected)));
    }

    // Go to Payroll#calculateAndPay isTest is introduced which is messing the code, here prefer mockcs an depend on interfaces

    private static Stream<Arguments> calculatorProvider() {
        return Stream.of(
            Arguments.of(-1.0, 4.5, "sum", 3.5),
            Arguments.of(1.0, -4.5, "sum", -3.5),
            Arguments.of(0.0, 0.0, "sum", 0.0),
            Arguments.of(0.0, 0.0, "sub", 0.0)
        );
    }
}
