package unit.tests;

public class Payroll {
    private final Calculator calculator = new Calculator();

    public void calculateAndPay(final String employeeId, final Double baseSalary) throws Exception {
        Double taxes = DB.getDiscount("taxes");
        Double calculatedSalary = calculator.Calculate(
            baseSalary,
            calculator.Calculate(baseSalary, taxes, "*"),
            "-");

            DB.setPayment(employeeId, calculatedSalary);
    }

    public Double getCurrentPayment(final String employeeId) {
        return DB.getPayment(employeeId);
    }
}
