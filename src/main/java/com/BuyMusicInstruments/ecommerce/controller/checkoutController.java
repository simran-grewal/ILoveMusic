package com.BuyMusicInstruments.ecommerce.controller;

import com.BuyMusicInstruments.ecommerce.dto.Purchase;
import com.BuyMusicInstruments.ecommerce.dto.PurchaseResponse;
import com.BuyMusicInstruments.ecommerce.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("/api/checkout")
public class checkoutController {
    private CheckoutService checkoutService;

    @Autowired
    public checkoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {

        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);
        return purchaseResponse;
    }
}
