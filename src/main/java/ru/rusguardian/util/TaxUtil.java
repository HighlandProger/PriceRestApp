package ru.rusguardian.util;

import ru.rusguardian.domain.CountryTax;
import ru.rusguardian.exception.CalculatePriceException;

public class TaxUtil {

    private TaxUtil() {
    }

    public static int getTaxRateFromTaxNumber(String taxNumber) {
        try {
            CountryTax tax = CountryTax.valueOf(taxNumber.substring(0, 2));
            if (!isNumeric(taxNumber.substring(2))) {
                throw new CalculatePriceException("Tax number must contain only digits: " + taxNumber);
            }
            return tax.getTaxRate();
        } catch (IllegalArgumentException e) {
            throw new CalculatePriceException("Unknown country code in tax number: " + taxNumber);
        }
    }

    public static boolean isNumeric(String str) {
        return str != null && str.matches("^[0-9]+$");
    }
}
