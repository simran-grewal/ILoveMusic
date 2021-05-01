package com.BuyMusicInstruments.ecommerce.service;

import com.BuyMusicInstruments.ecommerce.dao.CustomerRepository;
import com.BuyMusicInstruments.ecommerce.dto.Purchase;
import com.BuyMusicInstruments.ecommerce.dto.PurchaseResponse;
import com.BuyMusicInstruments.ecommerce.entity.Customer;
import com.BuyMusicInstruments.ecommerce.entity.Order;
import com.BuyMusicInstruments.ecommerce.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;

    //Autowired is option here because we have only one constructor
    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        // retrieve the order info from dto
        Order order = purchase.getOrder();

        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        // populate order with orderItems
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));

        // populate order with billingAddress and shippingAddress
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        // Populate customer with order
        Customer customer = purchase.getCustomer();
        customer.add(order);

        // save to the database
        customerRepository.save(customer);

        // return a response
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        // generate a random UUID // hard to guess, random and unique // universal unique identifier
        return UUID.randomUUID().toString();
    }
}
