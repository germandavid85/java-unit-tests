package unit.tests;

public class Calculator {
        public double Calculate(int first, int second, String operator) throws Exception {
        double result;

        switch(operator)
        {
            case "+":
                result = first + second;
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
}
