package ru.rusguardian.util;

import org.springframework.stereotype.Service;
import ru.rusguardian.domain.Coupon;

import java.util.Optional;

@Service
public class CalculatePriceUtil {

    private CalculatePriceUtil() {
    }

    public static double calculate(double shopPrice, int taxRate, String couponCode) {
        double priceWithSale = Math.max(shopPrice - getCouponSale(shopPrice, couponCode), 0.0);
        return priceWithSale + getTax(shopPrice, taxRate);
    }

    private static double getCouponSale(double shopPrice, String couponCode) {
        Optional<Coupon> couponOptional = CouponUtil.getCouponFromCouponCode(couponCode);
        if (couponOptional.isEmpty()) {
            return 0;
        }
        Coupon coupon = couponOptional.get();
        return switch (coupon.getType()) {
            case PERCENTAGE -> shopPrice * ((double) coupon.getValue() / 100);
            case AMOUNT -> coupon.getValue();
        };
    }

    private static double getTax(double shopPrice, int taxValue) {
        return shopPrice * ((double) taxValue / 100);
    }
}
