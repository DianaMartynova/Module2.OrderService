package org.example.printer;

import org.example.model.Order;
import org.example.model.Receipt;

public class ReceiptPrinter {
    public void print(Receipt receipt) {
        Order order = receipt.order();
        System.out.println("=== RECEIPT ===");
        System.out.println("Order ID: " + order.id());
        System.out.println("Items: " + order.items());
        System.out.println("Base amount: " + order.amount());
        System.out.println("Discount: -" + receipt.discount());
        System.out.println("Commission: +" + receipt.commission());
        System.out.println("Final amount: " + receipt.finalAmount());
        System.out.println("================");
    }
}
