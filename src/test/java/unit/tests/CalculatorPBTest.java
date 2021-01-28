package unit.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.Disabled;
import net.jqwik.api.ForAll;
import net.jqwik.api.Label;
import net.jqwik.api.Property;
import net.jqwik.api.Provide;

public class CalculatorPBTest {
    private Calculator calculator = new Calculator();

    // function name represents conditions and post conditions
    // @Property marks this as the property we are testing, this is executed either until one fail or until the configured number of tries is reached (1000 by default)
    // @ForAll this tells jqwik to generate the paramters
    // method can return void and use and assertio or return boolean and check manually
    @Property
    void sumOperatorMustSum(@ForAll double first, @ForAll double second) throws Exception {
        assertThat(calculator.Calculate(first, second, "+"), is(equalTo(first + second)));
    }

    @Property
    @Label("Sum result in a different order must be the same")
    void sumIsCommutative(@ForAll double first, @ForAll double second) throws Exception {
        assertThat(calculator.Calculate(first, second, "+"), is(equalTo(calculator.Calculate(second, first, "+"))));
    }

    @Property
    void sumIsNeutral(@ForAll double first, @ForAll double second) throws Exception {
        double actual = calculator.Calculate(first, second, "+");
        double actualPlusZero = calculator.Calculate(actual, 0.0, "+");

        assertThat(actual, is(equalTo(actualPlusZero)));
    }

    @Property
    @Disabled
    void sumIsAssociative(@ForAll double first) throws Exception {
        double actual = calculator.Calculate(calculator.Calculate(first, 1.0, "+"), 1.0, "+");
        double associativeResult = calculator.Calculate(1.0, 1.0, "+");
        double actualPlusZero = calculator.Calculate(first, associativeResult, "+");

        assertThat(actual, is(equalTo(actualPlusZero)));
    }

    @Property
    void sumOperatorMustSumWithReport(@ForAll double first, @ForAll double second) throws Exception {
        assertThat(calculator.Calculate(first, second, "+"), is(equalTo(first + second)));
    }

    @Property(tries = 5, seed = "88745489")
    void sumOperatorMustSumWithSeed(@ForAll double first, @ForAll double second) throws Exception {
        assertThat(calculator.Calculate(first, second, "+"), is(equalTo(first + second)));
    }

    // division

    @Property
    void divisionByOneIsTheSame(@ForAll double first) throws Exception {
        assertThat(calculator.Calculate(first, 1.0, "/"), is(equalTo(first)));
    }

    @Property
    void divisionByItselfIsOne(@ForAll("divisionNumbers") double first) throws Exception {
        assertThat(calculator.Calculate(first, first, "/"), is(equalTo(1.0)));
    }

    @Property
    @Disabled
    void zeroDividedByAnyIsZero(@ForAll double first) throws Exception {
        assertThat(calculator.Calculate(0.0, first, "/"), is(equalTo(0.0)));
    }

    @Property
    @Disabled
    void divisionByZeroIsInvalid(@ForAll double first) throws Exception {
        assertThat(calculator.Calculate(first, 0.0, "/"), is(equalTo(Double.POSITIVE_INFINITY)));
    }

    @Provide
    Arbitrary<Double> divisionNumbers() {
        return Arbitraries.doubles().filter(num -> num != 0.0);
    }
}
