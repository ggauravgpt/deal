package com.example.demo.repository;

import com.example.demo.dbo.Deal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DealRepository extends JpaRepository<Deal, Long> {

    Deal save(Deal deal);

    List<Deal> findAll();


}
