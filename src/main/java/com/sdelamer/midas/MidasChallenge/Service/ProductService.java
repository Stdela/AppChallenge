package com.sdelamer.midas.MidasChallenge.Service;

import java.util.List;

import com.sdelamer.midas.MidasChallenge.Dto.ProductDto;
import com.sdelamer.midas.MidasChallenge.Exception.NotFoundException;
import com.sdelamer.midas.MidasChallenge.Model.Product;

public interface ProductService {

	List<Product> findAllProducts();

	Product findProductById(Long id) throws NotFoundException;

	ProductDto updateProduct(Long id, ProductDto productDto);

	Product save(ProductDto productDto);

	void deleteProductById(Long id);

}
