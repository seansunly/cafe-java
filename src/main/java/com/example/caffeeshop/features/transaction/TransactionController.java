package com.example.caffeeshop.features.transaction;

import com.example.caffeeshop.features.transaction.dtoTransaction.TransactionCreate;
import com.example.caffeeshop.features.transaction.dtoTransaction.TransactionResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/transaction")
public class TransactionController {
    private final TransactionService transactionService;
    @GetMapping
    public List<TransactionResponse> getTransactions() {
        return transactionService.getTransactions();
    }

    @GetMapping("/{codeTransaction}")
    public TransactionResponse getTransaction(@PathVariable @Valid String codeTransaction) {
        return transactionService.getTransaction(codeTransaction);
    }

    @PostMapping
    public TransactionResponse createTransaction (@Valid @RequestBody TransactionCreate transactionCreate) {
        return transactionService.createTransaction(transactionCreate);
    }

    @DeleteMapping("/{codeTransaction}")
    public  void deleteTransaction(@PathVariable @Valid String codeTransaction) {
        transactionService.deleteTransaction(codeTransaction);
    }
}
