package org.example.discount;

import org.example.Order;

public class VipDiscountStrategy implements DiscountStrategy {
    @Override
    public double calculateDiscount(Order order) {
        return order.getAmount() * 0.05;
    }

    @Override
    public String customerType() {
        return "VIP";
    }
}