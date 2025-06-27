package com.example.demo.dtos;

import java.time.OffsetDateTime;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;

public record TransacaoDTO(
    @NotNull
    @PositiveOrZero
    Double valor,
    @NotNull
    @PastOrPresent
    OffsetDateTime dataHora

) {}
