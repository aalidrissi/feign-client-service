package com.cih.feignclientservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cih.feignclientservice.entity.Adress;

public interface FeignClientRepository extends JpaRepository<Adress, Integer> {

}
