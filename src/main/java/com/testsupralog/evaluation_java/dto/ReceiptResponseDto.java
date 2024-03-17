package com.testsupralog.evaluation_java.dto;

import com.testsupralog.evaluation_java.entities.Product;
import lombok.*;

import java.util.List;

@Getter
@Setter

@NoArgsConstructor
public class ReceiptResponseDto {

    private List<Product> products;
    private double total;
    private double totalTaxes;


    public ReceiptResponseDto(List<Product> productList, double total, double totalTaxes) {
    }
}
