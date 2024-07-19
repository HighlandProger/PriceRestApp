package ru.rusguardian.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CalculatePriceDto {

    private Long product;
    @JsonProperty("tax_number")
    private String taxNumber;
    @JsonProperty("coupon_code")
    private String couponCode;
}
