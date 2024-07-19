package ru.rusguardian.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.rusguardian.controller.dto.CalculatePriceDto;
import ru.rusguardian.controller.dto.ErrorMessageDto;
import ru.rusguardian.controller.dto.PurchaseDto;
import ru.rusguardian.exception.CalculatePriceException;
import ru.rusguardian.exception.PurchaseException;
import ru.rusguardian.service.processor.ProcessCalculatePrice;
import ru.rusguardian.service.processor.ProcessPurchase;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PaymentController {

    private final ProcessCalculatePrice processCalculatePrice;
    private final ProcessPurchase processPurchase;

    @PostMapping("/calculate-price")
    public ResponseEntity<?> calculatePrice(@RequestBody CalculatePriceDto dto) {
        try {
            double result = processCalculatePrice.process(dto);
            return ResponseEntity.ok("Price calculated successfully: " + result);
        } catch (CalculatePriceException e) {
            log.error("Error during price calculation: {}", e.getMessage());
            return ResponseEntity.badRequest().body(new ErrorMessageDto(e.getMessage()));
        }
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> purchase(@RequestBody PurchaseDto dto) {
        try {
            processPurchase.process(dto);
            return ResponseEntity.ok("Purchased successfully");
        } catch (PurchaseException e) {
            log.error("Error during price calculation: {}", e.getMessage());
            return ResponseEntity.badRequest().body(new ErrorMessageDto(e.getMessage()));
        }
    }
}
