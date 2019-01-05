package com.custoemrRegistration.Controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.autoconfigure.RefreshAutoConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.custoemrRegistration.beans.UserBean;
import com.custoemrRegistration.service.UserRegistrationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ImportAutoConfiguration(RefreshAutoConfiguration.class)
@SpringBootTest(classes = UserRegistrationController.class)
public class UserRegistrationControllerTest {

	@Autowired
    private WebApplicationContext context;
	
	private MockMvc mockMvc;
	
	@MockBean
	private UserRegistrationService userService;
	
	@Before
    public void setUp() {
     mockMvc = MockMvcBuilders.webAppContextSetup(context)
             .build();
    }
	
	@Test
	public void saveUserDataTest() throws Exception {
		//Mockito.when(userService.saveUser(new UserBean())).thenReturn(1);
		this.mockMvc.perform(post("/registration"))
			.andExpect(status().isOk())
			.andExpect(view().name("userRegistration"))
			.andDo(print());
	}
}
