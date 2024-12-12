package com.example.caffeeshop.features.transaction;

import com.example.caffeeshop.doman.Transaction;
import com.example.caffeeshop.features.transaction.dtoTransaction.TransactionCreate;
import com.example.caffeeshop.features.transaction.dtoTransaction.TransactionResponse;
import com.example.caffeeshop.features.transaction.dtoTransaction.TransactionUpdate;

import java.util.List;

public interface TransactionService {
    TransactionResponse createTransaction(TransactionCreate transactionCreate);

    void deleteTransaction(String codeTransaction);
    TransactionResponse getTransaction(String codeTransaction);
    List<TransactionResponse> getTransactions();
}
