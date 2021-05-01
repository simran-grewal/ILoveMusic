package com.BuyMusicInstruments.ecommerce.dao;

import com.BuyMusicInstruments.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin("http://localhost:8080")
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Select * from product where category_id=?
    //localhost:5000/api/products/search/findByCategoryId?id=1
    Page<Product> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);

    // Search Product from search-box
    //Select * from Product p where p.name like Concat('%', :name, '%')
    //localhost:5000/api/products/search/findByNameContaining?name=piano
    Page<Product> findByNameContaining(@RequestParam("name") String name, Pageable pageable);
}
