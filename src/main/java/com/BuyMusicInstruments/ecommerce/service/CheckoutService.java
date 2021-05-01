package com.BuyMusicInstruments.ecommerce.service;

import com.BuyMusicInstruments.ecommerce.dto.Purchase;
import com.BuyMusicInstruments.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);

}
