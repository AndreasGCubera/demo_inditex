package com.example.demo;

import com.example.demo.controller.PriceController;
import com.example.demo.model.Price;
import com.example.demo.service.PriceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(PriceController.class)
class PriceControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PriceService priceService;

	@Test
	void test1() throws Exception {

		Price mockPrice = new Price();
		mockPrice.setPrice(new BigDecimal("35.50"));

		when(priceService.getApplicablePrice(1, 35455, LocalDateTime.of(2020, 6, 14, 10, 0)))
				.thenReturn(mockPrice);

		mockMvc.perform(get("/price")
						.param("brandId", "1")
						.param("productId", "35455")
						.param("startDate", "2020-06-14T10:00:00"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price").value("35.5"));
	}

	@Test
	void test2() throws Exception {

		Price mockPrice = new Price();
		mockPrice.setPrice(new BigDecimal("25.45"));

		when(priceService.getApplicablePrice(1, 35455, LocalDateTime.of(2020, 6, 14, 16, 0)))
				.thenReturn(mockPrice);

		mockMvc.perform(get("/price")
						.param("brandId", "1")
						.param("productId", "35455")
						.param("startDate", "2020-06-14T10:00:00"))
				.andExpect(status().isNotFound());
	}

	@Test
	void test3() throws Exception {

		Price mockPrice = new Price();
		mockPrice.setPrice(new BigDecimal("35.50"));

		when(priceService.getApplicablePrice(1, 35455, LocalDateTime.of(2020, 6, 14, 21, 0)))
				.thenReturn(mockPrice);

		mockMvc.perform(get("/price")
						.param("brandId", "1")
						.param("productId", "35455")
						.param("startDate", "2020-06-14T10:00:00"))
				.andExpect(status().isNotFound());
	}

	@Test
	void test4() throws Exception {

		Price mockPrice = new Price();
		mockPrice.setPrice(new BigDecimal("35.50"));

		when(priceService.getApplicablePrice(1, 35455, LocalDateTime.of(2020, 6, 15, 10, 0)))
				.thenReturn(mockPrice);

		mockMvc.perform(get("/price")
						.param("brandId", "1")
						.param("productId", "35455")
						.param("startDate", "2020-06-14T10:00:00"))
				.andExpect(status().isNotFound());
	}

	@Test
	void test5() throws Exception {

		Price mockPrice = new Price();
		mockPrice.setPrice(new BigDecimal("35.50"));

		when(priceService.getApplicablePrice(1, 35455, LocalDateTime.of(2020, 6, 16, 21, 0)))
				.thenReturn(mockPrice);

		mockMvc.perform(get("/price")
						.param("brandId", "1")
						.param("productId", "35455")
						.param("startDate", "2020-06-14T10:00:00"))
				.andExpect(status().isNotFound());
	}
}
