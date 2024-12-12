package com.example.caffeeshop.features.transaction;

import com.example.caffeeshop.doman.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    Optional<Transaction> findByCodeTransaction(String codeTransaction);
    Boolean existsByCodeTransaction(String codeTransaction);
}
