package org.example.discount;

import org.example.model.Order;

import static org.example.utils.Rates.VIP_DISCOUNT_RATE;

public class VipDiscount implements DiscountStrategy {
    @Override
    public double calculate(Order order) {
        return order.amount() * VIP_DISCOUNT_RATE;
    }
}
