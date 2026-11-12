package org.example.payment;

import org.example.Order;

public class CashCommissionStrategy implements CommissionStrategy {
    @Override
    public double calculateCommission(Order order) {
        return 0.0;
    }

    @Override
    public String paymentType() {
        return "CASH";
    }
}
