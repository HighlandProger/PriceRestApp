package ru.rusguardian.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatePriceUtilTest {

    @Test
    void calculate_shouldCalculatePrice() {
        double price = 100;
        int taxRate = 25;
        String couponCode = "P10";

        double expectedValue = 115;
        double actualValue = CalculatePriceUtil.calculate(price, taxRate, couponCode);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void calculate_shouldCalculatePrice_whenCouponSaleIs100Percents() {
        double price = 200;
        int taxRate = 25;
        String couponCode = "P100";

        double expectedValue = 50;
        double actualValue = CalculatePriceUtil.calculate(price, taxRate, couponCode);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void calculate_shouldCalculatePrice_whenCouponSaleMoreThanShopPrice() {
        double price = 4;
        int taxRate = 25;
        String couponCode = "A5";

        double expectedValue = 1;
        double actualValue = CalculatePriceUtil.calculate(price, taxRate, couponCode);

        assertEquals(expectedValue, actualValue);
    }
}