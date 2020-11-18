package unit.tests.domain;

import unit.tests.persistence.DB;

public class PTOPayment {
    private static final double MONTH_TOTAL_DAYS = 30d;
    private final Calculator calculator;
    private final DB db;

    public PTOPayment(final Calculator calculator, final DB db) {
        this.calculator = calculator;
        this.db = db;
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

        db.setVacationsPayment(employeeId, vacationsToPay);
    }

    public Double getCurrentPayment(final String employeeId) {
        return db.getVacationsPayment(employeeId);
    }

}
