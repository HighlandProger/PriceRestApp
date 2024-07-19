package ru.rusguardian.util;

import org.junit.jupiter.api.Test;
import ru.rusguardian.domain.CountryTax;
import ru.rusguardian.exception.CalculatePriceException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TaxUtilTest {

    @Test
    void getTaxRateFromTaxNumber_shouldReturnTaxRate() {
        String taxNumber = "DE214235532";

        int expectedTaxRate = CountryTax.DE.getTaxRate();
        int actualTaxRate = TaxUtil.getTaxRateFromTaxNumber(taxNumber);

        assertEquals(expectedTaxRate, actualTaxRate);
    }

    @Test
    void getTaxRateFromTaxNumber_shouldThrowExceptionForUnknownTaxRegion() {
        String taxNumber = "CE214235532";

        Exception e = assertThrows(CalculatePriceException.class, () -> TaxUtil.getTaxRateFromTaxNumber(taxNumber));

        assertEquals("Unknown country code in tax number: " + taxNumber, e.getMessage());
    }


    @Test
    void getTaxRateFromTaxNumber_shouldThrowExceptionForWrongPatternString() {
        String taxNumber = "DE1235g!6789";

        Exception e = assertThrows(CalculatePriceException.class, () -> TaxUtil.getTaxRateFromTaxNumber(taxNumber));

        assertEquals("Wrong pattern for country: Germany", e.getMessage());
    }

}