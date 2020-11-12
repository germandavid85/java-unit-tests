package unit.tests;

public class Payroll {
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

    public Double getCurrentPayment(final String employeeId) {
        return db.getPayment(employeeId);
    }
}
