package org.example.payment;

import java.util.HashMap;
import java.util.Map;

public class CommissionStrategyFactory {

    private final Map<String, CommissionStrategy> strategies = new HashMap<>();

    public CommissionStrategyFactory() {
        register(new CardCommissionStrategy());
        register(new CashCommissionStrategy());
        register(new TransferCommissionStrategy());
    }

    private void register(CommissionStrategy strategy) {
        strategies.put(strategy.paymentType(), strategy);
    }

    public CommissionStrategy getStrategy(String paymentType) {
        CommissionStrategy strategy = strategies.get(paymentType);
        if (strategy == null) {
            throw new RuntimeException("Unknown payment type: " + paymentType);
        }
        return strategy;
    }
}
