package org.example.discount;

import org.example.model.Order;

import static org.example.utils.Rates.PREMIUM_DISCOUNT_RATE;

public class PremiumDiscount implements DiscountStrategy {
    @Override
    public double calculate(Order order) {
        return order.amount() * PREMIUM_DISCOUNT_RATE;
    }
}
