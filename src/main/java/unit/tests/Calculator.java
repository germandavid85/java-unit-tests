package unit.tests;

public class Calculator {
    public Double Calculate(Double first, Double second, String operator) throws Exception {
        Double result;

        switch(operator)
        {
            case "+":
                result = sum(first, second);
                break;

            case "-":
                result = first - second;
                break;

            case "*":
                result = first * second;
                break;

            case "/":
                result = first / second;
                break;

            case "%":
                result = first % second;
                break;

            default:
                throw new Exception("invalid operator");
        }

        return result;
    }

    Double sum(final Double first, final Double second) {
        return first +  second;
    }
}
