package com.testsupralog.evaluation_java.mappers;

import com.testsupralog.evaluation_java.dto.ProductRequestDto;
import com.testsupralog.evaluation_java.dto.ProductResponseDto;
import com.testsupralog.evaluation_java.entities.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product fromProductRequestDto (ProductRequestDto productRequestDto);

    ProductResponseDto fromProduct (Product product);

}
