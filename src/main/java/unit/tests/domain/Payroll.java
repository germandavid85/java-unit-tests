package unit.tests.domain;

import unit.tests.persistence.DB;

public class Payroll {
    private static final Double RETIREMENT_PLAN_PERCENTAGE = 0.1;
    private Calculator calculator = new Calculator();
    private DB db = new DB();

    public void calculateAndPay(final String employeeId, final Double baseSalary) throws Exception {
        Double taxes = db.getDiscount("taxes");
        Double calculatedSalary = calculator.Calculate(
            baseSalary,
            calculator.Calculate(baseSalary, taxes, "*"),
            "-");

            db.setPayment(employeeId, calculatedSalary);
    }

    public Double calculateRetirementPlan(final Double baseSalary) throws Exception {
        return calculator.Calculate(
            baseSalary,
            calculator.Calculate(baseSalary, RETIREMENT_PLAN_PERCENTAGE, "*"),
            "-");
    }

    public Double getCurrentPayment(final String employeeId) {
        return db.getPayment(employeeId);
    }
}
