package ru.rusguardian.util;

import org.springframework.stereotype.Service;
import ru.rusguardian.domain.Coupon;

@Service
public class CalculatePriceUtil {

    private CalculatePriceUtil() {
    }

    public static double calculate(double shopPrice, int taxRate, Coupon coupon) {
        double priceWithSale = Math.max(shopPrice - getCouponSale(shopPrice, coupon), 0.0);
        return priceWithSale + getTax(shopPrice, taxRate);
    }

    private static double getCouponSale(double shopPrice, Coupon coupon) {
        return switch (coupon.getType()) {
            case PERCENTAGE -> shopPrice * ((double) coupon.getValue() / 100);
            case AMOUNT -> coupon.getValue();
        };
    }

    private static double getTax(double shopPrice, int taxValue) {
        return shopPrice * ((double) taxValue / 100);
    }
}
