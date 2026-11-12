package org.example.discount;

import org.example.Order;

public class PremiumDiscountStrategy implements DiscountStrategy {
    @Override
    public double calculateDiscount(Order order) {
        return order.getAmount() * 0.10;
    }

    @Override
    public String customerType() {
        return "PREMIUM";
    }
}
