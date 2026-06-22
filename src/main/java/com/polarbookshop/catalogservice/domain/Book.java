package com.polarbookshop.catalogservice.domain;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record Book (
    @NotBlank(message = "isbn must not be blank")
    String isbn,
    @NotBlank(message = "title must not be blank")
    String title,
    @NotBlank(message = "author must not be blank")
    String author,
    @NotNull(message = "price must not be null")
    @Positive(message = "price must be greater than zero")
    Double price
) {
}
