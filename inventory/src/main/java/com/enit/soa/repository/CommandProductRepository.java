package com.enit.soa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enit.soa.domain.CommandDetails;


@Repository
public interface CommandProductRepository extends JpaRepository<CommandDetails, Long>{

}
