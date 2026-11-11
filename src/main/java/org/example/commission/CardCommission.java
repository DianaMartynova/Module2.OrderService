package org.example.commission;

import org.example.model.Order;

import static org.example.utils.Rates.CARD_COMMISSION_RATE;

public class CardCommission implements CommissionStrategy {
    @Override
    public double calculate(Order order) {
        return order.amount() * CARD_COMMISSION_RATE;
    }
}
