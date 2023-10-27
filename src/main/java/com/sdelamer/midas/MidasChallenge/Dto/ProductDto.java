package com.sdelamer.midas.MidasChallenge.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Min;

public class ProductDto {

	@Schema(description = "Name of the product", example = "Sample Product")
	@Nonnull
	@Min(value = 0)
	private String name;

	@Schema(description = "Price of the product", minimum = "0", example = "25.99")
	@Nonnull
	@Min(value = 0, message = "Price must be grater than or equal to 0")
	private Double price;
	@Schema(description = "Count of the product", example = "100")
	@Nonnull
	private Long count;

	public ProductDto() {

	}

	public ProductDto(String name, Double price, Long count) {
		super();
		this.name = name;
		this.price = price;
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

}
