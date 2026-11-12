package org.example.payment;

import org.example.Order;

public class CardCommissionStrategy implements CommissionStrategy {
    @Override
    public double calculateCommission(Order order) {
        return order.getAmount() * 0.02;
    }

    @Override
    public String paymentType() {
        return "CARD";
    }
}
