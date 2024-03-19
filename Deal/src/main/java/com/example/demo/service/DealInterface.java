package com.example.demo.service;


import com.example.demo.dbo.Deal;
import com.example.demo.dbo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DealInterface {

    Deal createDeal(Deal deal);

    List<Deal> getLiveDeal();
    User createUser(User user);
    Deal editDeal( Deal deal);
    boolean endDeal(Long dealId);

    boolean claim(Long dealId);
}
