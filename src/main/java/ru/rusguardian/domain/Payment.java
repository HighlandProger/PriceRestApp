package ru.rusguardian.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Payment {

    PAYPAL("paypal"),
    STRIPE_PAYMENT_PROCESSOR("stripe");

    private final String value;

    public static Payment fromValue(String value) {
        for (Payment payment : values()) {
            if (payment.getValue().equalsIgnoreCase(value)) {
                return payment;
            }
        }
        throw new IllegalArgumentException("Invalid payment type: " + value);
    }
}
