package unit.tests;

public class Payroll {
    private static final Double RETIREMENT_PLAN_PERCENTAGE = 0.1;
    private Calculator calculator = new Calculator();
    private final PaymentDataAccess paymentDataAccess;

    public Payroll(final PaymentDataAccess paymentDataAccess) {
        this.paymentDataAccess = paymentDataAccess;
    }

    public void calculateAndPay(final String employeeId, final Double baseSalary) throws Exception {
        Double taxes = paymentDataAccess.getDiscount("taxes");

        Double calculatedSalary = calculator.Calculate(
            baseSalary,
            calculator.Calculate(baseSalary, taxes, "*"),
            "-");

        paymentDataAccess.setPayment(employeeId, calculatedSalary);
    }

    public Double calculateRetirementPlan(final Double baseSalary) throws Exception {
        return calculator.Calculate(
            baseSalary,
            calculator.Calculate(baseSalary, RETIREMENT_PLAN_PERCENTAGE, "*"),
            "-");
    }

    public Double getCurrentPayment(final String employeeId) {
        return paymentDataAccess.getPayment(employeeId);
    }
}
