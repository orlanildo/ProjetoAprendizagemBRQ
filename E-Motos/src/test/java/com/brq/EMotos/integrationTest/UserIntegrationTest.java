
package com.brq.EMotos.integrationTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.brq.EMotos.models.User;
import com.brq.EMotos.services.LoginService;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserIntegrationTest {

	@Autowired
	public LoginService loginService;
	
	@Autowired
	public WebApplicationContext context;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
    private ObjectMapper objectMapper;
	
	
	@Before
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
		
		User userLogin = new User();
		
		userLogin.setEmail("xpto@brq.com");
		userLogin.setPassword("1234");
		
		this.mockMvc.perform(post("/login")
		.contentType("application/json")
		.content(objectMapper.writeValueAsString(userLogin)))
        .andExpect(status().isOk());
	}


	@Test
	public void testFindUserById() throws Exception {
		
		this.mockMvc.perform(get("/user/showUser/3"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("user"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.email").value("user@brq.com"));
	}
	
	@Test
	public void testFindAllUser() throws Exception {
		
		this.mockMvc.perform(get("/user/listUser/"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON));
			//.andExpect(content().equals(new ArrayList<User>()));
					
	}
	
	@Test
	public void testCreateUser() throws Exception {
		
		this.mockMvc.perform(get("/user/criateUser/"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON));
			//.andExpect(content().equals(new ArrayList<User>()));
					
	}
	
	@Test
	public void testUpdateUser() throws Exception {
		
		this.mockMvc.perform(get("/user/updateUser/"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON));
			//.andExpect(content().equals(new ArrayList<User>()));
					
	}
	
	@Test
	public void testDeleteUser() throws Exception {
		
		this.mockMvc.perform(get("/user/deleteUser/"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON));
			//.andExpect(content().equals(new ArrayList<User>()));
					
	}


}
