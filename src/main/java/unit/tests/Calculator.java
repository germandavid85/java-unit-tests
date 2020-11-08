package unit.tests;

public class Calculator {
        public double Calculate(int first, int second, String operator) {
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

            default:
                System.out.printf("Error! operator is not correct");
                return 0.0;
        }

        return result;
    }
}
