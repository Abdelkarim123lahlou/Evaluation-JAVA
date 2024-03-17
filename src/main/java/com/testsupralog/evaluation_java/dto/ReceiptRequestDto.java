package com.testsupralog.evaluation_java.dto;

import com.testsupralog.evaluation_java.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReceiptRequestDto {

    private String products;
    private double total;
    private double totalTaxes;
}
