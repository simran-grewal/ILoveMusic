package com.BuyMusicInstruments.ecommerce.dao;

import com.BuyMusicInstruments.ecommerce.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:8080")
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
