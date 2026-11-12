package org.example.payment;

import org.example.Order;

public class TransferCommissionStrategy implements CommissionStrategy {
    @Override
    public double calculateCommission(Order order) {
        return order.getAmount() * 0.01;
    }

    @Override
    public String paymentType() {
        return "TRANSFER";
    }
}
