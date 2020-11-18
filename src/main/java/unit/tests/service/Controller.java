package unit.tests.service;

import unit.tests.domain.PTOPayment;
import unit.tests.domain.Payroll;

public class Controller {
    private final Payroll payroll;
    private final PTOPayment ptoPayment;

    public Controller(final Payroll payroll, final PTOPayment ptoPayment) {
        this.payroll = payroll;
        this.ptoPayment = ptoPayment;
    }

    public final EmployeePayment calculateSalary(final String employeeId, final Double baseSalary, final Double totalVacations) throws Exception {
        payroll.calculateAndPay(employeeId, baseSalary);
        ptoPayment.calculateAndPay(employeeId, baseSalary, totalVacations);

        return new EmployeePayment(payroll.getCurrentPayment(employeeId), ptoPayment.getCurrentPayment(employeeId));
    }
}
