package ru.rusguardian.util;

import ru.rusguardian.domain.Coupon;
import ru.rusguardian.exception.CalculatePriceException;

import java.util.Optional;

public class CouponUtil {

    private CouponUtil() {
    }

    public static Optional<Coupon> getCouponFromCouponCode(String couponCode) {
        if (couponCode.isEmpty()) return Optional.empty();
        try {
            return Optional.of(Coupon.valueOf(couponCode));
        } catch (IllegalArgumentException e) {
            throw new CalculatePriceException("Coupon with code " + couponCode + " not found");
        }
    }
}
