package com.sdelamer.midas.MidasChallenge.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sdelamer.midas.MidasChallenge.Dto.ProductDto;
import com.sdelamer.midas.MidasChallenge.Model.Product;

@Component
public class ProductMapper {

	@Autowired
	ModelMapper modelMapper;
	
	public Product productDtoToProduct(ProductDto productDto) {
		Product product = new Product(); 
		 modelMapper.map(productDto, product);
		return product;
	}
	
	public ProductDto productToProductDto(Product product) {
		return modelMapper.map(product, ProductDto.class);

	}
	
	
	
}
