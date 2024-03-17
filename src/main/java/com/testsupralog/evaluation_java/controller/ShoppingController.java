package com.testsupralog.evaluation_java.controller;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.testsupralog.evaluation_java.dto.ProductRequestDto;
import com.testsupralog.evaluation_java.dto.ReceiptResponseDto;
import com.testsupralog.evaluation_java.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShoppingController {

    private final ShoppingService shoppingService;

    @Autowired
    public ShoppingController(ShoppingService shoppingService) {
        this.shoppingService = shoppingService;
    }

    @PostMapping(value = "/generateReceipt", produces =  MediaType.APPLICATION_JSON_VALUE)

    public ReceiptResponseDto generateReceipt(@RequestBody List<ProductRequestDto> products) {
        return shoppingService.generateReceipt(products);
    }
}
