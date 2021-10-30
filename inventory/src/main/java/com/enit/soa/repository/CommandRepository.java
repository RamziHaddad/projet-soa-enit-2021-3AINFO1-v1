package com.enit.soa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enit.soa.domain.Command;
import com.enit.soa.domain.Product;

@Repository
public interface CommandRepository extends JpaRepository<Command, Long>  {

}
