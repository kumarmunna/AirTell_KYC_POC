package com.airtel.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.airtel.demo.dto.CustomerDto;


@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

	/*@InjectMocks
	private CustomerService customerService;	
	*/
	
	@Test
    public void getAllCustomersTest()
    {
        List<CustomerDto> list = new ArrayList<CustomerDto>();
    /*    CustomerDto empOne = new Customer("1", "qqq","1234", "abc@dk.com", "Approved", "12", "23");
        CustomerDto empTwo = new Customer("2", "name2", "phone2", "email2", "Pending", "33", "43");
        CustomerDto empThree = new Customer("3", "name3", "phone3", "email3", "Rejected", "45", "56");
         
        list.add(empOne);
        list.add(empTwo);
        list.add(empThree);
         
        //when(customerService.getAllCustomers()).thenReturn(list);
         
        //test
        //List<CustomerDto> customersList = customerService.getAllCustomers();
         
        //assertEquals(3, customersList.size());
        verify(customerService, times(1)).getAllCustomers();
        */
    }
     
    @Test
    public void getCustomerByIdTest()
    {
       // when(customerService.getCustomerById("1").get()).thenReturn(new Customer("1", "qqq","1234", "abc@dk.com", "Approved", "12", "23"));
         
        //CustomerDto customer = customerService.getCustomerById("1").get();
         
		/*
		 * assertEquals("qqq", customer.getName()); assertEquals("1234",
		 * customer.getPhone()); assertEquals("abc@dk.com", customer.getEmail());
		 */
    }
    
}
