package ru.rusguardian.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PurchaseDto {

    private Long product;
    @JsonProperty("tax_number")
    private String taxNumber;
    @JsonProperty("coupon_code")
    private String couponCode;
    @JsonProperty("payment_processor")
    private String paymentProcessor;
}
