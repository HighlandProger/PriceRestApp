package ru.rusguardian.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CountryTax {

    DE("Germany", 19),
    IT("Italy", 22),
    FR("France", 20),
    GR("Greece", 24);

    private final String country;
    private final int taxRate;
}
