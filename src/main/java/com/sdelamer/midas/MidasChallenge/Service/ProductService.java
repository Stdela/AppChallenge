package com.sdelamer.midas.MidasChallenge.Service;

import java.util.List;

import com.sdelamer.midas.MidasChallenge.Dto.ProductDto;
import com.sdelamer.midas.MidasChallenge.Exception.DataAlreadyExistsException;
import com.sdelamer.midas.MidasChallenge.Exception.NotFoundException;
import com.sdelamer.midas.MidasChallenge.Model.Product;

public interface ProductService {

	List<Product> findAllProducts();

	Product findProductById(Long id) throws NotFoundException;

	ProductDto updateProduct(Long id, ProductDto productDto) throws NotFoundException;

	Product save(ProductDto productDto) throws DataAlreadyExistsException;

	void deleteProductById(Long id) throws NotFoundException;

}
