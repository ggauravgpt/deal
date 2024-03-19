package com.example.demo.service;

import com.example.demo.dbo.Deal;
import com.example.demo.dbo.User;
import com.example.demo.repository.DealRepository;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class DealService implements DealInterface {

    private final DealRepository dealRepository;

    private final UserRepository userRepository;

    private static final Logger LOGGER = (Logger) LogManager.getLogger(DealService.class);



    @Override
    public Deal createDeal(Deal deal) {

        try{
            //validate userId.

            return dealRepository.save(deal);
        }catch (Exception ex){
            LOGGER.error("Error while creating deal");
            throw  new RuntimeException();
        }
    }

    @Override
    public List<Deal> getLiveDeal() {
        List<Deal> deals =  dealRepository.findAll();

        return deals.stream().filter(a -> !a.isExpire()).collect(Collectors.toList());

    }


    @Override
    public User createUser(User user) {

        return userRepository.save(user);

    }

    @Override
    public Deal editDeal(Deal deal) {

        Optional<Deal> existingdeal =  dealRepository.findById(deal.getDealId());

        if(existingdeal.isPresent()){
            return  dealRepository.save(deal);
        }
        return null;
    }

    @Override
    public boolean endDeal(Long dealId) {

        Optional<Deal> deal = dealRepository.findById(dealId);

        if(deal.isPresent()){
            deal.get().setExpire(true);
            dealRepository.save(deal.get());
        }

        return false;
    }

    @Override
    public boolean claim(Long dealId) {
        return false;
    }
}
