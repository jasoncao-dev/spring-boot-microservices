package dev.jasoncao.customer;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    @Autowired
    private MockMvc mockMvc;

    /*
    @Test
    public void shouldRegisterCustomerSuccessfully() throws Exception {
        CustomerRegistrationRequest request = new CustomerRegistrationRequest("Test", "User", "test@test.com");

        doNothing().when(customerService).registerCustomer(request);

        mockMvc.perform(post("/api/v1/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(request)))
                .andExpect(status().isOk());
    }
     */
}