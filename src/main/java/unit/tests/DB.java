package unit.tests;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DB {
    private static final Map<String, Double> CURRENT_PAYMENT = new ConcurrentHashMap<>();
    private static final Map<String, Double> VACATIONS_PAYMENT = new ConcurrentHashMap<>();
    private static final Map<String, Double> DISCOUNTS = Map.of(
        "taxes", 0.15
    );

    public double getPayment(final String key) {
        return CURRENT_PAYMENT.get(key);
    }

    public void setPayment(final String key, final Double value) {
        CURRENT_PAYMENT.put(key, value);
    }

    public double getVacationsPayment(final String key) {
        return VACATIONS_PAYMENT.get(key);
    }

    public void setVacationsPayment(final String key, final Double value) {
        VACATIONS_PAYMENT.put(key, value);
    }

    public double getDiscount(final String key) {
        return DISCOUNTS.get(key);
    }
}
