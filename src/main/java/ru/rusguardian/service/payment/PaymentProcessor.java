package ru.rusguardian.service.payment;

public interface PaymentProcessor {

    void makePayment(Integer price) throws Exception;

    boolean pay(Float price);
}
