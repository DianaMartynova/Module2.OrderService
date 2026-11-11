package org.example.model;

import java.util.List;

/**
 * @param customerType  "REGULAR", "VIP", "PREMIUM"
 * @param paymentType  "CARD", "CASH", "TRANSFER" */
public record Order(String id, String customerType, String paymentType, List<String> items, double amount) {
}
