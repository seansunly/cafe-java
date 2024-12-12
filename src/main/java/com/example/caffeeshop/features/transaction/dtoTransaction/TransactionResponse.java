package com.example.caffeeshop.features.transaction.dtoTransaction;

import jakarta.validation.constraints.NotEmpty;

public record TransactionResponse(
        String codeTransaction,
        String description,
        String imageQRCode,
        Integer type,
        Boolean isDeleted,
        String createAt,
        String updateAt,
        String content,
        String codeUser,
        String codeOrder,
        String firstNameUser,
        String lastNameUser,
        Float greteTotal,
        Float getMoneyUsa$,
        Integer getMoneyRile,
        Float moneyPayBack$,
        Integer moneyPayBackRile
) {
}
