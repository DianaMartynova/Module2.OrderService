package org.example.discount;

import org.example.model.Order;

public class RegularDiscount implements DiscountStrategy {
    @Override
    public double calculate(Order order) {
        return 0.0;
    }
}
