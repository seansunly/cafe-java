package com.example.caffeeshop.features.transaction.dtoTransaction;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;

public record TransactionCreate(
         String codeTransaction,
         String description,
         @NotEmpty(message = "image QRCode is not empty")
         String imageQRCode,
         Integer type,
         Boolean isDeleted,
         String createAt,
         String updateAt,
         String content,
         Float getMoneyUsa$,
         Integer getMoneyRile,

         String codeUser,
         String codeOrder
) {
}
