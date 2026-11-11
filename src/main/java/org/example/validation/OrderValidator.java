package org.example.validation;

import org.example.model.Order;

public class OrderValidator {
    public void validate(Order order) {
        if (order.amount() <= 0) {
            throw new RuntimeException("Order amount must be positive");
        }
        if (order.items() == null || order.items().isEmpty()) {
            throw new RuntimeException("Order must contain at least one item");
        }
    }
}
