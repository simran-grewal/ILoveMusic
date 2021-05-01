package com.BuyMusicInstruments.ecommerce.dao;

import com.BuyMusicInstruments.ecommerce.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@CrossOrigin("http://localhost:8080")
@RepositoryRestResource
public interface StateRepository extends JpaRepository<State, Integer> {

    //localhost:5000/api/states/search/findByCountryCode?code=IN
    List<State> findByCountryCode(@RequestParam("code") String code);
}
