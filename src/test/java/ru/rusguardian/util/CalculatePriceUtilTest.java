package ru.rusguardian.util;

import org.junit.jupiter.api.Test;
import ru.rusguardian.domain.Coupon;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatePriceUtilTest {

    @Test
    void calculate_shouldCalculatePrice() {
        double price = 100;
        int taxRate = 25;
        Coupon coupon = Coupon.P10;

        double expectedValue = 115;
        double actualValue = CalculatePriceUtil.calculate(price, taxRate, coupon);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void calculate_shouldCalculatePrice_whenCouponSaleIs100Percents() {
        double price = 200;
        int taxRate = 25;
        Coupon coupon = Coupon.P100;

        double expectedValue = 50;
        double actualValue = CalculatePriceUtil.calculate(price, taxRate, coupon);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void calculate_shouldCalculatePrice_whenCouponSaleMoreThanShopPrice() {
        double price = 4;
        int taxRate = 25;
        Coupon coupon = Coupon.A5;

        double expectedValue = 1;
        double actualValue = CalculatePriceUtil.calculate(price, taxRate, coupon);

        assertEquals(expectedValue, actualValue);
    }
}