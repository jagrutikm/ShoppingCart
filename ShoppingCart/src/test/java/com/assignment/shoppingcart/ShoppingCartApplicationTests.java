package com.assignment.shoppingcart;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.awt.PageAttributes.MediaType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration
@SpringBootTest
class ShoppingCartApplicationTests {

	@Autowired 
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;
	
		
	@Test
	void contextLoads() {
	}
	
	@BeforeEach
	private void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}
	
	@Test
	public void addToCartTest() throws Exception {
		String payload ="  {\n"
				+ "         \"productid\": 12,\n"
				+ "        \"name\": \"CC\",\n"
				+ "        \"description\" : \"CC product\",\n"
				+ "        \"price\": 1500,        \n"
				+ "         \"quantity\" : 2,\n"
				+ "        \"cartitems\" : {\n"
				+ "            \"id\": 1\n"
				+ "                   \n"
				+ "      \n"
				+ "    }\n"
				+ "\n"
				+ "        \n"
				+ "    }\n"
				+ "";
		
		mockMvc.perform(post("/addProduct").contentType(org.springframework.http.MediaType.APPLICATION_JSON).content(payload));
		 			
	}
	
	@Test
	public void fetchCartByIdTest() throws Exception {
		mockMvc.perform(get("/fetchCartById/{cartId}", 1)).andExpect(status().isOk()).andReturn();
		
				 
	}
	
	@Test
	public void removeFromCartTest() throws Exception {
		mockMvc.perform(delete("/deleteProduct/{productid}", 12)).andExpect(status().isOk()).andReturn();
		
				 
	}

}
