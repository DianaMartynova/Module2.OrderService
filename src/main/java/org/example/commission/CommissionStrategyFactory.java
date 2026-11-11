package org.example.commission;

import org.example.commission.enums.PaymentType;

import java.util.Map;
import java.util.function.Supplier;

public class CommissionStrategyFactory {

    private static final Map<PaymentType, Supplier<CommissionStrategy>> STRATEGIES = Map.of(
            PaymentType.CARD,     CardCommission::new,
            PaymentType.CASH,     CashCommission::new,
            PaymentType.TRANSFER, TransferCommission::new
    );

    public static CommissionStrategy create(String paymentType) {
        PaymentType type = PaymentType.fromString(paymentType);
        Supplier<CommissionStrategy> supplier = STRATEGIES.get(type);
        if (supplier == null) {
            throw new RuntimeException("Unknown payment type: " + paymentType);
        }
        return supplier.get();
    }
}
