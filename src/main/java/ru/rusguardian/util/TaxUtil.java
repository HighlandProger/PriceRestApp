package ru.rusguardian.util;

import ru.rusguardian.domain.CountryTax;
import ru.rusguardian.exception.CalculatePriceException;

public class TaxUtil {

    private TaxUtil() {
    }

    public static int getTaxRateFromTaxNumber(String taxNumber) {
            CountryTax tax = getCountryTax(taxNumber);
            String taxInnerNumber = taxNumber.substring(2);
            checkValidity(taxInnerNumber, tax);
            return tax.getTaxRate();

    }

    public static CountryTax getCountryTax(String taxNumber){
        try {
            return CountryTax.valueOf(taxNumber.substring(0, 2));
        } catch (IllegalArgumentException e) {
            throw new CalculatePriceException("Unknown country code in tax number: " + taxNumber);
        }
    }

    public static void checkValidity(String value, CountryTax tax) {
        String pattern;
        try {
            pattern = GeneratePatternUtil.generate(tax.getPatternMask());
        } catch (IllegalArgumentException e) {
            throw new CalculatePriceException(e.getMessage());
        }
        if(!value.matches(pattern)) {
            throw new CalculatePriceException("Wrong pattern for country: " + tax.getCountry());
        }
    }
}
