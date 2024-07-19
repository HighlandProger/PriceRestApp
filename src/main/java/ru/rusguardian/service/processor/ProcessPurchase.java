package ru.rusguardian.service.processor;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.rusguardian.controller.dto.CalculatePriceDto;
import ru.rusguardian.controller.dto.PurchaseDto;
import ru.rusguardian.domain.Payment;
import ru.rusguardian.exception.PurchaseException;
import ru.rusguardian.service.payment.PaymentProcessor;

@Service
public class ProcessPurchase {

    private final ProcessCalculatePrice processCalculatePrice;
    private final PaymentProcessor paypal;
    private final PaymentProcessor stripePaymentProcessor;

    public ProcessPurchase(ProcessCalculatePrice processCalculatePrice, @Qualifier("paypal") PaymentProcessor paypal, @Qualifier("stripePaymentProcessor") PaymentProcessor stripePaymentProcessor) {
        this.processCalculatePrice = processCalculatePrice;
        this.paypal = paypal;
        this.stripePaymentProcessor = stripePaymentProcessor;
    }

    public boolean process(PurchaseDto dto) {
        Payment payment = getPayment(dto.getPaymentProcessor());
        return makePurchase(processCalculatePrice.process(new CalculatePriceDto(dto.getProduct(), dto.getTaxNumber(), dto.getCouponCode())), payment);
    }

    private boolean makePurchase(double price, Payment payment) {
        return switch (payment) {
            case PAYPAL -> {
                try {
                    paypal.makePayment((int) price);
                    yield true;
                } catch (Exception e) {
                    throw new PurchaseException("Failed to make payment by paypal");
                }
            }
            case STRIPE_PAYMENT_PROCESSOR -> stripePaymentProcessor.pay((float) price);
        };
    }

    private Payment getPayment(String paymentValue) {
        return Payment.fromValue(paymentValue);
    }
}
