package org.example.commission.enums;

public enum PaymentType {
    CARD,
    CASH,
    TRANSFER;

    public static PaymentType fromString(String value) {
        if (value == null) {
            throw new RuntimeException("Unknown payment type: null");
        }
        try {
            return PaymentType.valueOf(value);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Unknown payment type: " + value);
        }
    }
}
