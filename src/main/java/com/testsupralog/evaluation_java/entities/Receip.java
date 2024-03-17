package com.testsupralog.evaluation_java.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Receip {


    private List<Product> products;
    private double total;
    private double totalTaxes;
}
