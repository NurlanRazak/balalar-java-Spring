package com.example.balalar;
import com.example.balalar.Buy;
import java.util.List;
import java.util.Optional;

import com.example.balalar.data.BuyRepository;
import com.example.balalar.data.IBuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyService implements IBuyService {

    @Autowired
    private BuyRepository buyRepo;

    @Override
    public List<Buy> findAll(){

        List<Buy> buys = (List<Buy>) buyRepo.findAll();

        return buys;

    }
//    @Override
//    public Optional<Buy> getById() {
//
//        Optional<Buy> buy = (Optional<Buy>) buyRepo.findById(id);
//
//        return buy;
//
//    }
}
