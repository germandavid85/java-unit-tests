package unit.tests;

public class DBDummy implements PaymentDataAccess {
    private double payment = 0D;

    @Override
    public double getPayment(String key) {
        return payment;
    }

    @Override
    public void setPayment(String key, Double value) {
        payment = value;
    }

    @Override
    public double getVacationsPayment(String key) {
        return 0;
    }

    @Override
    public void setVacationsPayment(String key, Double value) {
    }

    @Override
    public double getDiscount(String key) {
        return 0;
    }
}
