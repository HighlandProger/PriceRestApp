package ru.rusguardian.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CountryTax {

    DE("Germany", 19, "XXXXXXXXX"),
    IT("Italy", 22, "XXXXXXXXXXX"),
    FR("France", 20, "XXXXXXXXX"),
    GR("Greece", 24, "YYXXXXXXXXX");

    private final String country;
    private final int taxRate;
    private final String patternMask;
}
