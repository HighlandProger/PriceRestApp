package ru.rusguardian.service.processor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rusguardian.controller.dto.CalculatePriceDto;
import ru.rusguardian.domain.Product;
import ru.rusguardian.exception.CalculatePriceException;
import ru.rusguardian.service.data.ProductService;
import ru.rusguardian.util.CalculatePriceUtil;
import ru.rusguardian.util.TaxUtil;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProcessCalculatePrice {

    private final ProductService productService;

    public double process(CalculatePriceDto dto) {
        int taxRate = TaxUtil.getTaxRateFromTaxNumber(dto.getTaxNumber());
        Product product = getProduct(dto.getProduct());

        return CalculatePriceUtil.calculate(product.getPrice(), taxRate, dto.getCouponCode());
    }

    private Product getProduct(long productId) {
        try {
            return productService.getProductById(productId);
        } catch (NoSuchElementException e) {
            throw new CalculatePriceException("Product with id " + productId + " not found");
        }
    }

}
