package org.example.discount.enums;

public enum CustomerType {
    REGULAR,
    VIP,
    PREMIUM;

    public static CustomerType fromString(String value) {
        if (value == null) {
            throw new RuntimeException("Unknown customer type: null");
        }
        try {
            return CustomerType.valueOf(value);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Unknown customer type: " + value);
        }
    }
}
