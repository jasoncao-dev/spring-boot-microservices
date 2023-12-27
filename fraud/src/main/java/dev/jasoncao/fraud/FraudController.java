package dev.jasoncao.fraud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("api/v1/fraud-check")
public record FraudController(FraudCheckService fraudCheckService) {
    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable Integer customerId) {
        log.info("Fraud check for customer {}", customerId);
        return new FraudCheckResponse(fraudCheckService.isFraudulentCustomer(customerId));
    }
}
