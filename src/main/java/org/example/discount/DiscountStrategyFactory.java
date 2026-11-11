package org.example.discount;

import org.example.discount.enums.CustomerType;

import java.util.Map;
import java.util.function.Supplier;

import static org.example.discount.enums.CustomerType.*;

public class DiscountStrategyFactory {

    private static final Map<CustomerType, Supplier<DiscountStrategy>> STRATEGIES = Map.of(
            REGULAR, RegularDiscount::new,
            VIP,     VipDiscount::new,
            PREMIUM, PremiumDiscount::new
    );

    public static DiscountStrategy create(String customerType) {
        CustomerType type = CustomerType.fromString(customerType);
        Supplier<DiscountStrategy> supplier = STRATEGIES.get(type);
        if (supplier == null) {
            throw new RuntimeException("Unknown customer type: " + customerType);
        }
        return supplier.get();
    }
}
