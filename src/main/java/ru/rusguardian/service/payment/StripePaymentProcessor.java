package ru.rusguardian.service.payment;

import org.springframework.stereotype.Service;

@Service
public class StripePaymentProcessor implements PaymentProcessor {

    @Override
    public void makePayment(Integer price) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean pay(Float price) {
        return price >= 100;
    }
}
