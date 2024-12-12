package com.example.caffeeshop.mapper;

import com.example.caffeeshop.doman.Transaction;
import com.example.caffeeshop.features.transaction.dtoTransaction.TransactionCreate;
import com.example.caffeeshop.features.transaction.dtoTransaction.TransactionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
@Mapper(componentModel = "spring")
public interface TransactionMapper {
    @Mapping(source = "codeUser",target = "user.codeUser")
    @Mapping(source = "codeOrder",target = "order.codeOrder")
    Transaction createTransaction(TransactionCreate transactionCreate);

    @Mapping(source = "user.codeUser",target = "codeUser")
    @Mapping(source = "order.codeOrder",target = "codeOrder")
    //firstNameUser,
    //        String middleNameUser,
    //        String lastNameUser
    @Mapping(source = "user.firstName",target = "firstNameUser")
    @Mapping(source = "user.lastName",target = "lastNameUser")
    @Mapping(source = "order.greteTotal",target = "greteTotal")
    TransactionResponse entityToResponse(Transaction transaction);

    List<TransactionResponse> entityToResponseList(List<Transaction> transactions);
}
