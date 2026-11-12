package org.example.discount;

import org.example.Order;

public class RegularDiscountStrategy implements DiscountStrategy {
    @Override
    public double calculateDiscount(Order order) {
        return 0.0;
    }

    @Override
    public String customerType() {
        return "REGULAR";
    }
}
