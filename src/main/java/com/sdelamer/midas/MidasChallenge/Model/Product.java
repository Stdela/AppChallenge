package com.sdelamer.midas.MidasChallenge.Model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column()
	@Nonnull
	private String name;

	@Column()
	@Nonnull
	private Double price;

	@Column()
	@Nonnull
	private Long count;

	public Product() {
	}

	public Product(String name, Double price, Long count) {
		this.name = name;
		this.price = price;
		this.count = count;
	}

	public Long getId() {
		return id;
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
