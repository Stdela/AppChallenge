package com.sdelamer.midas.MidasChallenge.Dto;

public class ProductDto {

	String name;
	Double price;
	Long count;

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
