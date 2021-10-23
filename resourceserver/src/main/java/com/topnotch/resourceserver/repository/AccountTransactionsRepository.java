package com.topnotch.resourceserver.repository;

import java.util.List;

import com.topnotch.resourceserver.model.AccountTransactions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTransactionsRepository extends CrudRepository<AccountTransactions, Long> {

    List<AccountTransactions> findByEmailOrderByTransactionDtDesc(String email);

}
