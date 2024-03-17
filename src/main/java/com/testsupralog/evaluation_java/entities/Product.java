package com.testsupralog.evaluation_java.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {

    private String name;
    private double price;
    private boolean imported;
    private boolean taxExempt;
}
