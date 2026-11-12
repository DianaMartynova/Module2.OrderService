package org.example;

import org.example.discount.DiscountStrategy;
import org.example.discount.DiscountStrategyFactory;
import org.example.payment.CommissionStrategy;
import org.example.payment.CommissionStrategyFactory;
import org.example.receipt.ConsoleReceiptPrinter;
import org.example.receipt.ReceiptPrinter;
import org.example.validation.DefaultOrderValidator;
import org.example.validation.OrderValidator;

import java.util.ArrayList;
import java.util.List;

public class OrderService {

    private final List<Order> orders = new ArrayList<>();

    private final DiscountStrategyFactory discountFactory;
    private final CommissionStrategyFactory commissionFactory;
    private final OrderValidator validator;
    private final ReceiptPrinter receiptPrinter;

    public OrderService() {
        this(new DiscountStrategyFactory(),
             new CommissionStrategyFactory(),
             new DefaultOrderValidator(),
             new ConsoleReceiptPrinter());
    }

    public OrderService(DiscountStrategyFactory discountFactory,
                        CommissionStrategyFactory commissionFactory,
                        OrderValidator validator,
                        ReceiptPrinter receiptPrinter) {
        this.discountFactory = discountFactory;
        this.commissionFactory = commissionFactory;
        this.validator = validator;
        this.receiptPrinter = receiptPrinter;
    }

    public double processOrder(Order order) {
        validator.validate(order);

        DiscountStrategy discountStrategy = discountFactory.getStrategy(order.getCustomerType());
        CommissionStrategy commissionStrategy = commissionFactory.getStrategy(order.getPaymentType());

        double discount = discountStrategy.calculateDiscount(order);
        double commission = commissionStrategy.calculateCommission(order);
        double finalAmount = order.getAmount() - discount + commission;

        receiptPrinter.print(order, discount, commission, finalAmount);

        orders.add(order);
        return finalAmount;
    }

    public static void main(String[] args) {
        OrderService service = new OrderService();

        Order order1 = new Order("1", "VIP", "CARD", List.of("Laptop", "Mouse"), 1000.0);
        Order order2 = new Order("2", "REGULAR", "CASH", List.of("Book"), 20.0);

        System.out.println("Final amount 1: " + service.processOrder(order1));
        System.out.println("Final amount 2: " + service.processOrder(order2));
    }
}

