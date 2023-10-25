package com.sdelamer.midas.MidasChallenge.Model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Product {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false)
	    private String name;

	    @Column(nullable = false)
	    private Double price;

	    @Column(nullable = false)
	    private Long count;

	    // Constructores, getters y setters

	    public Product() {
	        // Constructor vacío requerido por JPA
	    }

	    public Product(String name, Double price, Long count) {
	        this.name = name;
	        this.price = price;
	        this.count = count;
	    }

	    // Getters y setters para todos los campos

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
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
