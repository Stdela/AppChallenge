package com.sdelamer.midas.MidasChallenge.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ProductDto {

	@Schema(description = "Name of the product", example = "Sample Product")
	@Nonnull
	@Size(min = 6, message = "Product must have a meaningful name")
	@NotBlank
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

	public ProductDto(@NotBlank String name, @Min(value = 0)Double price, Long count) {
		super();
		this.name = name;
		this.price = price;
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(@NotBlank String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice( @Min(value = 0) Double price) {
		this.price = price;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

}
