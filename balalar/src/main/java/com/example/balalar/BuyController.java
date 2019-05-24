package com.example.balalar;

import javax.validation.Valid;

import com.example.balalar.data.BuyRepository;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/buys")
@SessionAttributes("buy")

public class BuyController {

    private BuyRepository buyRepository;

    public BuyController(BuyRepository buyRepository) { this.buyRepository = buyRepository; }

    @GetMapping("/current")
    public String orderForm() {
        return "buyForm";
    }

    @PostMapping
    public String processOrder(@Valid Buy buy, Errors errors, SessionStatus sessionStatus) {
        if(errors.hasErrors()){
            return "buyForm";
        }


        buyRepository.save(buy);
        System.out.println(buy);
        sessionStatus.setComplete();
        return "redirect:/main";
    }
}
