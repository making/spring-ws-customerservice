package com.example.customerservice;

import static org.assertj.core.api.Assertions.assertThat;

import javax.xml.bind.JAXBElement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CustomerServiceApplicationTests {

	@Autowired
	WebServiceTemplate webServiceTemplate;

	@Test
	@SuppressWarnings("unchecked")
	public void testGetCustomersByName() {
		GetCustomersByName request = new GetCustomersByName();
		request.setName("maki");
		GetCustomersByNameResponse o = ((JAXBElement<GetCustomersByNameResponse>) webServiceTemplate
				.marshalSendAndReceive(request)).getValue();
		assertThat(o).isNotNull();
		assertThat(o.getReturn()).hasSize(1);
		Customer customer = o.getReturn().get(0);
		assertThat(customer.getName()).isEqualTo("maki");
		assertThat(customer.getType()).isEqualTo(CustomerType.BUSINESS);
		assertThat(customer.getBirthDate()).isEqualTo(LocalDate.of(2000, 1, 1));
	}

}
