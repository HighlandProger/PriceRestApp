package ru.rusguardian.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Coupon {

    P10(CouponType.PERCENTAGE, 10),
    P100(CouponType.PERCENTAGE, 100),
    A5(CouponType.AMOUNT, 5);

    private final CouponType type;
    private final int value;

    public enum CouponType {
        PERCENTAGE,
        AMOUNT
    }
}
