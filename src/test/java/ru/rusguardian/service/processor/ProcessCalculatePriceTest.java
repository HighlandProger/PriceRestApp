package ru.rusguardian.service.processor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.rusguardian.controller.dto.CalculatePriceDto;
import ru.rusguardian.domain.Product;
import ru.rusguardian.exception.CalculatePriceException;
import ru.rusguardian.service.data.ProductService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ProcessCalculatePriceTest {

    @Mock
    private ProductService productService;
    @InjectMocks
    private ProcessCalculatePrice processCalculatePrice;

    @Test
    void process_shouldReturnCalculatedProcess() {
        CalculatePriceDto dto = new CalculatePriceDto(1L, "GR3414532", "P10");

        when(productService.getProductById(dto.getProduct())).thenReturn(new Product(1L, "Iphone", 100L));

        double expectedValue = 114;
        double actualValue = processCalculatePrice.process(dto);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void process_shouldThrowCalculateException_whenTaxNumberIncorrect() {
        CalculatePriceDto dto = new CalculatePriceDto(1L, "GW3414532", "P10");

        Exception e = assertThrows(CalculatePriceException.class, () -> processCalculatePrice.process(dto));

        String expectedValue = "Unknown country code in tax number: " + dto.getTaxNumber();
        String actualValue = e.getMessage();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void process_shouldThrowCalculateException_whenCouponIncorrect() {
        CalculatePriceDto dto = new CalculatePriceDto(1L, "DE3414532", "P20");

        Exception e = assertThrows(CalculatePriceException.class, () -> processCalculatePrice.process(dto));

        String expectedValue = "Coupon with code " + dto.getCouponCode() + " not found";
        String actualValue = e.getMessage();

        assertEquals(expectedValue, actualValue);
    }

}