package org.example.model;

public record Receipt(Order order, double discount, double commission, double finalAmount) {
}
