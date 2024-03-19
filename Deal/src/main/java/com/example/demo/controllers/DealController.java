package com.example.demo.controllers;

import com.example.demo.dbo.Deal;
import com.example.demo.dbo.User;
import com.example.demo.service.DealInterface;
import com.example.demo.service.DealService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DealController {
    private final DealInterface dealInterface;

    private static final Logger LOGGER = (Logger) LogManager.getLogger(DealService.class);

    @PostMapping("/createDeal")
    public Deal createDeal(@RequestParam Deal deal){
        return dealInterface.createDeal(deal);
    }

    @GetMapping("/getDeals")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Deal> createDeal(){
        return dealInterface.getLiveDeal();
    }



    @PostMapping("/createUser")
    public User createUser(@RequestParam User user){
        return new User();
    }

    @PutMapping("/editDeal")
    public Deal editDeal(@RequestParam Deal deal){
        return new Deal();
    }

    @PutMapping("/endDeal")
    public Deal endDeal(@RequestParam Integer dealId){
        return new Deal();
    }


}