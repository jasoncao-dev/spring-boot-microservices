package dev.jasoncao.customer;

import dev.jasoncao.clients.fraud.FraudCheckResponse;
import dev.jasoncao.clients.fraud.FraudClient;
import dev.jasoncao.clients.notification.NotificationClient;
import dev.jasoncao.clients.notification.NotificationRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerService(CustomerRepository customerRepository,
                              RestTemplate restTemplate,
                              FraudClient fraudClient,
                              NotificationClient notificationClient) {
    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        Customer customer = Customer.builder()
            .firstName(customerRegistrationRequest.firstName())
            .lastName(customerRegistrationRequest.lastName())
            .email(customerRegistrationRequest.email())
            .build();
        // TODO: Check if email valid
        // TODO: Check if email is already registered
        customerRepository.saveAndFlush(customer);
        FraudCheckResponse fraudCheckResponse =
                fraudClient.isFraudster(customer.getId());
        assert fraudCheckResponse != null;
        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("Customer is a fraud!");
        }
        notificationClient.sendNotification(
                NotificationRequest.builder()
                        .toCustomerId(customer.getId())
                        .toCustomerEmail(customer.getEmail())
                        .message("Welcome to our service!")
                        .build());
    }

    public Customer getCustomerById(Integer id) {
        return customerRepository.findById(id).orElseThrow();
    }
}
