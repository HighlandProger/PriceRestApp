package ru.rusguardian.service.data;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rusguardian.domain.Product;
import ru.rusguardian.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product getProductById(long productId) {
        return productRepository.findById(productId).orElseThrow();
    }
}
