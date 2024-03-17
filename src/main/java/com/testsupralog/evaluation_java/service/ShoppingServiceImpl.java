package com.testsupralog.evaluation_java.service;

import com.testsupralog.evaluation_java.dto.ProductRequestDto;
import com.testsupralog.evaluation_java.dto.ReceiptResponseDto;
import com.testsupralog.evaluation_java.entities.Product;
import com.testsupralog.evaluation_java.entities.Receip;
import com.testsupralog.evaluation_java.mappers.ProductMapper;
import com.testsupralog.evaluation_java.mappers.RecieptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingServiceImpl implements ShoppingService {
   private ProductMapper prodMapper;
   private RecieptMapper receiptMapper;
    @Autowired
    public ShoppingServiceImpl(ProductMapper prodMapper,RecieptMapper receiptMapper) {
        this.prodMapper = prodMapper;
        this.receiptMapper = receiptMapper;
    }

    @Override
    public ReceiptResponseDto generateReceipt(List<ProductRequestDto> products) {
        double total = 0;
        double totalTaxes = 0;

        StringBuilder receiptDetails = new StringBuilder();
        List<Product> productList = new ArrayList<>();

        for (ProductRequestDto product : products) {
            Product productFromDto = prodMapper.fromProductRequestDto(product);
            double taxes = calculateTaxRate(product);
            double totalPrice = product.getPrice() + taxes;
            total += totalPrice;
            totalTaxes += taxes;

            productList.add(productFromDto);

            receiptDetails.append(String.format("%d %s : %.2f%n", 1, product.getName(), totalPrice));
        }

        receiptDetails.append("--------------------\n");
        receiptDetails.append(String.format("Sales Taxes : %.2f%n", totalTaxes));
        receiptDetails.append(String.format("Total : %.2f%n", total));
        String receiptString = receiptDetails.toString();

        return new ReceiptResponseDto(productList, total, totalTaxes);
    }

    @Override
    public double calculateTaxRate(ProductRequestDto product) {
        double taxRate = 0.1; // Taxe de base de 10%

        // Vérifier si le produit est exempt de taxes
        if (product.isTaxExempt()) {
            taxRate = 0;
        }

        // Ajouter 5% de taxe pour les produits importés
        if (product.isImported()) {
            taxRate += 0.05;
        }

        // Calculer le montant des taxes pour le produit
        double taxes = product.getPrice() * taxRate;

        // Arrondir le montant des taxes au 0.05 le plus proche
        taxes = roundToNearest0_05(taxes);

        return taxes;
    }



    @Override
    public double roundToNearest0_05(double value) {
        return new BigDecimal(Double.toString(value))
                .setScale(2, RoundingMode.HALF_UP)
                .divide(new BigDecimal("0.05"), 0, RoundingMode.UP)
                .multiply(new BigDecimal("0.05"))
                .doubleValue();

    }

        /*@Override
        public double calculateTaxRate(ProductRequestDto product) {
            double taxRate = 0.1; // Taxe de base de 10%

            // Vérifier si le produit est exempt de taxes
            if (product.isTaxExempt()) {
                taxRate = 0;
            }

            // Ajouter 5% de taxe pour les produits importés
            if (product.isImported()) {
                taxRate += 0.05;
            }

            // Calculer le montant des taxes pour le produit
            double taxes = product.getPrice() * taxRate;

            // Arrondir le montant des taxes au 0.05 le plus proche
            taxes = roundToNearest0_05(taxes);

            return taxes;
    }

    @Override
    public boolean isTaxExempt(String productName) {
        return false;
    }

    @Override
    public double roundToNearest0_05(double value) {
        return new BigDecimal(Double.toString(value))
                .setScale(2, RoundingMode.HALF_UP)
                .divide(new BigDecimal("0.05"), 0, RoundingMode.UP)
                .multiply(new BigDecimal("0.05"))
                .doubleValue();
    }*/
}
