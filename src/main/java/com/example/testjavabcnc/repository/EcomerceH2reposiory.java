package com.example.testjavabcnc.repository;

import  com.example.testjavabcnc.entity.Price;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EcomerceH2reposiory extends CrudRepository<Price, Long> {
}
