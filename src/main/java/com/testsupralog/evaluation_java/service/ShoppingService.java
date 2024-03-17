package com.testsupralog.evaluation_java.service;

import com.testsupralog.evaluation_java.dto.ProductRequestDto;
import com.testsupralog.evaluation_java.dto.ReceiptResponseDto;

import java.util.List;

public interface ShoppingService {
    ReceiptResponseDto generateReceipt(List<ProductRequestDto> products);
    double calculateTaxRate(ProductRequestDto product);


    double roundToNearest0_05(double value);

}
