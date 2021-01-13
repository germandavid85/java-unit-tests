package unit.tests;

public class PTOPayment {
    private static final double MONTH_TOTAL_DAYS = 30d;
    private final Calculator calculator = new Calculator();
    private final PaymentDataAccess paymentDataAccess;

    public PTOPayment(final PaymentDataAccess paymentDataAccess) {
        this.paymentDataAccess = paymentDataAccess;
    }

    public void calculateAndPay(final String employeeId, final Double baseSalary, double days) throws Exception {
        Double dailySalary = calculator.Calculate(
            baseSalary,
            MONTH_TOTAL_DAYS,
            "/");

        Double vacationsToPay = calculator.Calculate(
            dailySalary,
            days,
            "*");

            paymentDataAccess.setVacationsPayment(employeeId, vacationsToPay);
    }

    public Double getCurrentPayment(final String employeeId) {
        return paymentDataAccess.getVacationsPayment(employeeId);
    }

}
