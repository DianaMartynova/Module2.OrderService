package org.example.commission;

import org.example.model.Order;

import static org.example.utils.Rates.TRANSFER_COMMISSION_RATE;

public class TransferCommission implements CommissionStrategy {
    @Override
    public double calculate(Order order) {
        return order.amount() * TRANSFER_COMMISSION_RATE;
    }
}
