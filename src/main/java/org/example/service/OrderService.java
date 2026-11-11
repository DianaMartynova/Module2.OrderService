package org.example.service;

import org.example.commission.CommissionStrategy;
import org.example.commission.CommissionStrategyFactory;
import org.example.discount.DiscountStrategy;
import org.example.discount.DiscountStrategyFactory;
import org.example.model.Order;
import org.example.model.Receipt;
import org.example.printer.ReceiptPrinter;
import org.example.validation.OrderValidator;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private final List<Order> orders = new ArrayList<>();
    private final OrderValidator validator = new OrderValidator();
    private final ReceiptPrinter printer = new ReceiptPrinter();

    public double processOrder(Order order) {
        validator.validate(order);

        DiscountStrategy discountStrategy = DiscountStrategyFactory.create(order.customerType());
        CommissionStrategy commissionStrategy = CommissionStrategyFactory.create(order.paymentType());

        double discount = discountStrategy.calculate(order);
        double commission = commissionStrategy.calculate(order);
        double finalAmount = order.amount() - discount + commission;

        printer.print(new Receipt(order, discount, commission, finalAmount));
        orders.add(order);

        return finalAmount;
    }

    public List<Order> getOrders() {
        return List.copyOf(orders);
    }
}
