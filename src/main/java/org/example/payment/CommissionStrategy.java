package org.example.payment;

import org.example.Order;

public interface CommissionStrategy {
    double calculateCommission(Order order);
    String paymentType();
}
