package dev.jasoncao.customer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    public void testGetCustomerById() {
        Customer customer = Customer.builder()
                .firstName("Test First Name")
                .lastName("Test Last Name")
                .email("test@test.com")
                .build();

        when(customerRepository.findById(1)).thenReturn(Optional.of(customer));

        Customer found = customerService.getCustomerById(1);

        assertEquals(customer, found);
        verify(customerRepository, times(1)).findById(1);
    }
}
