package org.example.commission;

import org.example.model.Order;

public interface CommissionStrategy {
    double calculate(Order order);
}
