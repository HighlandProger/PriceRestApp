package ru.rusguardian.util;

import ru.rusguardian.domain.Coupon;
import ru.rusguardian.exception.CalculatePriceException;

public class CouponUtil {

    private CouponUtil() {
    }

    public static Coupon getCouponFromCouponCode(String couponCode) {
        try {
            return Coupon.valueOf(couponCode);
        } catch (IllegalArgumentException e) {
            throw new CalculatePriceException("Coupon with code " + couponCode + " not found");
        }
    }
}
