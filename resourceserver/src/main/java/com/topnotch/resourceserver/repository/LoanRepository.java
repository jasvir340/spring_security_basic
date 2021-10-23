package com.topnotch.resourceserver.repository;

import java.util.List;

import com.topnotch.resourceserver.model.Loans;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends CrudRepository<Loans, Long> {

    List<Loans> findByEmailOrderByStartDtDesc(String email);

}

