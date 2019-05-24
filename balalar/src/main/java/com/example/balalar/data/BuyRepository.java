package com.example.balalar.data;

import org.springframework.data.repository.CrudRepository;

import com.example.balalar.Buy;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyRepository
        extends CrudRepository<Buy, Long>{

}
