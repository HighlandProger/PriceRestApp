package ru.rusguardian.service.payment;

import org.springframework.stereotype.Service;

@Service
public class Paypal implements PaymentProcessor {

    @Override
    public void makePayment(Integer price) throws Exception {
        if (price > 100000) {
            throw new Exception();
        }
    }

    @Override
    public boolean pay(Float price) {
        throw new UnsupportedOperationException();
    }
}
