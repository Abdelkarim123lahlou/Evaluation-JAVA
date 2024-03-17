package com.testsupralog.evaluation_java.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {
    private String name;
    private double price;
    private boolean imported;
    private boolean taxExempt;
}
