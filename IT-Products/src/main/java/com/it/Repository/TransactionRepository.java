package com.it.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.it.Model.TransactionEntity;

public interface TransactionRepository extends JpaRepository<TransactionEntity,String> {



}
