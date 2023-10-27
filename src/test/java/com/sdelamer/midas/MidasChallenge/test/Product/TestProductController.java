package com.sdelamer.midas.MidasChallenge.test.Product;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sdelamer.midas.MidasChallenge.Controller.ProductController;
import com.sdelamer.midas.MidasChallenge.Dto.ProductDto;
import com.sdelamer.midas.MidasChallenge.Exception.DataAlreadyExistsException;
import com.sdelamer.midas.MidasChallenge.Model.Product;
import com.sdelamer.midas.MidasChallenge.Repository.ProductRepository;
import com.sdelamer.midas.MidasChallenge.Service.ProductService;

@SpringBootTest
public class TestProductController {

	@Autowired
	private static MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;
	@Mock
	private ProductService productService;

	@Autowired
	private ObjectMapper objectMapper;
	@InjectMocks
	private ProductController productController;

	@MockBean
	ProductRepository productRepository;

	Product productToBeRepeated;
	Product productWronglyDesigned;

	ProductDto productDto1;
	ProductDto productDtoWronglyDesgined;
	List<Product> productGetAll;

	@BeforeEach
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).apply(springSecurity()).build();
		productToBeRepeated = new Product("Audifonos", 20.00, 1L);
		productWronglyDesigned = new Product("", -25.00, 2L);
		productDto1 = new ProductDto("Audifonos", 20.00, 1L);
		productDtoWronglyDesgined = new ProductDto("", -25.00, 2L);
		productGetAll = new ArrayList<>();
		productGetAll.add(productToBeRepeated);
		productGetAll.add(productWronglyDesigned);
		Mockito.when(productService.findAllProducts()).thenReturn(productGetAll);

	}

	@Test
	@WithMockUser(username = "mariano@gmail.com", roles = "ADMIN")
	public void test_post_product_bad_request() throws Exception {
		String JSONRequest = mapToJson(productDtoWronglyDesgined);

		mockMvc.perform(post("/products").content(JSONRequest).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest()).andReturn();
	}

	@Test
	@WithMockUser(username = "user", roles = "USER")
	public void test_post_product_unauthorized_request() throws Exception {
		String JSONRequest = mapToJson(productDtoWronglyDesgined);
		mockMvc.perform(post("/products").content(JSONRequest).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isForbidden()).andReturn();
	}

	

	@Test
	@WithMockUser(username = "mariano@gmail.com", roles = "ADMIN")
	public void get_products_ok() throws Exception {
		List<Product> productList = productService.findAllProducts();
		assertThat(productList).isNotEmpty();
		assertThat(productList.size()).isEqualTo(2);
		mockMvc.perform(get("/products")).andExpect(status().isOk());

	}

	private String mapToJson(Object object) throws JsonProcessingException {
		return objectMapper.writeValueAsString(object);

	}

}
