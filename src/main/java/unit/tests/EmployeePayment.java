package unit.tests;

public class EmployeePayment {
    private final Double baseSalary;
    private final Double vacations;

    public EmployeePayment(final Double baseSalary, final Double vacations) {
        this.baseSalary = baseSalary;
        this.vacations = vacations;
    }

    public Double getBaseSalary() {
        return this.baseSalary;
    }

    public Double getVacations() {
        return this.vacations;
    }

    public boolean hasVacationsPayment() {
        return this.vacations > 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof EmployeePayment)) {
            return false;
        }

        EmployeePayment employeePayment = (EmployeePayment) obj;

        return this.baseSalary.equals(employeePayment.getBaseSalary())
            && this.vacations.equals(employeePayment.getVacations());
    }
}
