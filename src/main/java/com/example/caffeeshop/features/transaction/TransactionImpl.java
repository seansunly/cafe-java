package com.example.caffeeshop.features.transaction;

import com.example.caffeeshop.doman.Order;
import com.example.caffeeshop.doman.Transaction;
import com.example.caffeeshop.doman.User;
import com.example.caffeeshop.features.order.OrderRepository;
import com.example.caffeeshop.features.transaction.dtoTransaction.TransactionCreate;
import com.example.caffeeshop.features.transaction.dtoTransaction.TransactionResponse;
import com.example.caffeeshop.features.user.UserRepository;
import com.example.caffeeshop.mapper.TransactionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final TransactionMapper transactionMapper;
    @Override
    public TransactionResponse createTransaction(TransactionCreate transactionCreate) {
        User user = userRepository.findByCodeUser(transactionCreate.codeUser())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        Order order = orderRepository.findByCodeOrder(transactionCreate.codeOrder())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));

        if (transactionRepository.existsByCodeTransaction(transactionCreate.codeTransaction())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Transaction already exists");
        }

// Map and initialize Transaction
        Transaction transaction = transactionMapper.createTransaction(transactionCreate);
        transaction.setUser(user);
        transaction.setOrder(order);
        transaction.setCodeTransaction(UUID.randomUUID().toString());
        transaction.setCreateAt(Date.from(Instant.now()));
        transaction.setUpdateAt(Date.from(Instant.now()));


//        if(transaction.getGetMoneyUsa$()>0){
//            // Retrieve necessary values with null-checks
//            Float getMoneyUsa$ = transactionCreate.getMoneyUsa$() != null ? transactionCreate.getMoneyUsa$() : 0f;
//            Float greteTotal = order.getGreteTotal() != null ? order.getGreteTotal() : 0f;
//
//// Calculate moneyPayBack$
//            Float moneyPayBack$ = getMoneyUsa$ - greteTotal;
//            transaction.setMoneyPayBack$(moneyPayBack$);
//            transaction.setMoneyPayBackRile((int) ((getMoneyUsa$ - greteTotal) * 4000));
//        }else if (transaction.getGetMoneyRile()>0) {
//            // Retrieve necessary values with null-checks
//            Float getMoneyRile = transactionCreate.getMoneyRile() != null ? transactionCreate.getMoneyRile() : 0f;
//            Float greteTotal = order.getGreteTotal() != null ? order.getGreteTotal() : 0f;
//
//// Calculate moneyPayBack$
//            Integer moneyPayBack$ = (int) (getMoneyRile - greteTotal * 4000);
//            //transaction.setMoneyPayBack$((float) (getMoneyRile - (greteTotal / 4000);
//            transaction.setMoneyPayBack$( (getMoneyRile - (greteTotal * 4000)) / 4000);
//            transaction.setMoneyPayBackRile(moneyPayBack$);
//        }
//        else if (transaction.getGetMoneyUsa$()<=0 && transaction.getGetMoneyRile()<=0) {
//            throw new ResponseStatusException(HttpStatus.CONFLICT, "please input money Rile ande USA");
//        }
////        else if (transaction.getGetMoneyUsa$()<=0 ) {
////            throw new ResponseStatusException(HttpStatus.CONFLICT, "please input money rile");
////        } else if (transaction.getGetMoneyRile()<=0) {
////            throw new ResponseStatusException(HttpStatus.CONFLICT, "please input money Usa");
////        }


// Save transaction
        transaction = transactionRepository.save(transaction);

        return transactionMapper.entityToResponse(transaction);

    }

    @Override
    public void deleteTransaction(String codeTransaction) {
        Transaction transaction = transactionRepository.findByCodeTransaction(codeTransaction)
                .orElseThrow(() -> new  ResponseStatusException(HttpStatus.NOT_FOUND,"Transaction not found"));

        transactionRepository.delete(transaction);
    }

    @Override
    public TransactionResponse getTransaction(String codeTransaction) {
        Transaction transaction = transactionRepository.findByCodeTransaction(codeTransaction)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Transaction not found"));
        transaction = transactionRepository.save(transaction);
        return transactionMapper.entityToResponse(transaction);
    }

    @Override
    public List<TransactionResponse> getTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        return transactionMapper.entityToResponseList(transactions);
    }
}
