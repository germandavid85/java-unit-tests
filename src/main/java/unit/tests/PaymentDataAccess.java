package unit.tests;

public interface PaymentDataAccess {
  public double getPayment(final String key);

  public void setPayment(final String key, final Double value);

  public double getVacationsPayment(final String key);

  public void setVacationsPayment(final String key, final Double value);

  public double getDiscount(final String key);
}
