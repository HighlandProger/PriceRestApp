package ru.rusguardian.util;

import org.junit.jupiter.api.Test;
import ru.rusguardian.domain.Coupon;
import ru.rusguardian.exception.CalculatePriceException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CouponUtilTest {

    @Test
    void getCouponFromCouponCode_shouldReturnCoupon() {
        String couponCode = "P100";

        Coupon expectedCoupon = Coupon.P100;
        Coupon actualCoupon = CouponUtil.getCouponFromCouponCode(couponCode);

        assertEquals(expectedCoupon, actualCoupon);
    }

    @Test
    void getCouponFromCouponCode_shouldThrowCalculateException_whenTypeNotFound() {
        String couponCode = "P142";

        Exception e = assertThrows(CalculatePriceException.class, () -> CouponUtil.getCouponFromCouponCode(couponCode));

        assertEquals("Coupon with code " + couponCode + " not found", e.getMessage());
    }
}