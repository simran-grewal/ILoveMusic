package com.BuyMusicInstruments.ecommerce.dto;

import com.BuyMusicInstruments.ecommerce.entity.Address;
import com.BuyMusicInstruments.ecommerce.entity.Customer;
import com.BuyMusicInstruments.ecommerce.entity.Order;
import com.BuyMusicInstruments.ecommerce.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}

// data transfer object