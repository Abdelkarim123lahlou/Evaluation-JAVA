package com.testsupralog.evaluation_java.mappers;

import com.testsupralog.evaluation_java.dto.ReceiptRequestDto;
import com.testsupralog.evaluation_java.dto.ReceiptResponseDto;
import com.testsupralog.evaluation_java.entities.Receip;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecieptMapper {
    Receip fromRequestReceiptDto(ReceiptRequestDto receiptRequestDto);
    ReceiptResponseDto fromReciept (Receip receipt);


}
