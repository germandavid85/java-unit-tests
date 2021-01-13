package unit.tests;

public class PayrollTooMuch {
    private static final Double RETIREMENT_PLAN_PERCENTAGE = 0.1;
    private final PaymentDataAccess paymentDataAccess;

    public PayrollTooMuch(final PaymentDataAccess paymentDataAccess) {
        this.paymentDataAccess = paymentDataAccess;
    }

    public void calculateAndPay(final String employeeId, final Double baseSalary) throws Exception {
        Double taxes = paymentDataAccess.getDiscount("taxes");
        Double calculatedSalary = calculate(
            baseSalary,
            calculate(baseSalary, taxes, "*"),
            "-");

            paymentDataAccess.setPayment(employeeId, calculatedSalary);
    }

    public Double calculateRetirementPlan(final Double baseSalary) throws Exception {
        return calculate(
            baseSalary,
            calculate(baseSalary, RETIREMENT_PLAN_PERCENTAGE, "*"),
            "-");
    }

    public Double getCurrentPayment(final String employeeId) {
        return paymentDataAccess.getPayment(employeeId);
    }

    public Double calculate(Double first, Double second, String operator) throws Exception {
        Double result;

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
