package unit.tests;

import java.util.HashMap;
import java.util.Map;

public class DB {
  private static final Map<String, Double> CURRENT_PAYMENT = new HashMap<>();
  private static final Map<String, Double> DISCOUNTS = Map.of(
      "taxes", 0.15
  );

  public static double getPayment(final String key) {
      return CURRENT_PAYMENT.get(key);
  }

  public static void setPayment(final String key, final Double value) {
      CURRENT_PAYMENT.put(key, value);
  }

  public static double getDiscount(final String key) {
      return DISCOUNTS.get(key);
  }
}
