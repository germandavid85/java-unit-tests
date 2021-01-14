package unit.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

public class CalculatorParametrizedTest {

    @ParameterizedTest
    @MethodSource("calculatorProvider")
    public void calculateTest(double first, double second, String operator, double expected) throws Exception {
        Calculator calc = new Calculator();

        assertThat(calc.Calculate(first, second, operator), is(equalTo(expected)));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "./calculator.csv", numLinesToSkip = 1)
    public void calculateCSVTest(double first, double second, String operator, double expected) throws Exception {
        Calculator calc = new Calculator();

        assertThat(calc.Calculate(first, second, operator), is(equalTo(expected)));
    }

    private static Stream<Arguments> calculatorProvider() {
        return Stream.of(
            Arguments.of(-1.0, 4.5, "+", 3.5),
            Arguments.of(1.0, -4.5, "+", -3.5),
            Arguments.of(0.0, 0.0, "+", 0.0),
            Arguments.of(0.0, 0.0, "-", 0.0)
        );
    }
}
