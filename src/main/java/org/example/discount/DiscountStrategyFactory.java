package org.example.discount;

import java.util.HashMap;
import java.util.Map;

public class DiscountStrategyFactory {

    private final Map<String, DiscountStrategy> strategies = new HashMap<>();

    public DiscountStrategyFactory() {
        register(new RegularDiscountStrategy());
        register(new VipDiscountStrategy());
        register(new PremiumDiscountStrategy());
    }

    private void register(DiscountStrategy strategy) {
        strategies.put(strategy.customerType(), strategy);
    }

    public DiscountStrategy getStrategy(String customerType) {
        DiscountStrategy strategy = strategies.get(customerType);
        if (strategy == null) {
            throw new RuntimeException("Unknown customer type: " + customerType);
        }
        return strategy;
    }
}
