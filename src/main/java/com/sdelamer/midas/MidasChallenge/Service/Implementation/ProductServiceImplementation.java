package com.sdelamer.midas.MidasChallenge.Service.Implementation;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdelamer.midas.MidasChallenge.Dto.ProductDto;
import com.sdelamer.midas.MidasChallenge.Exception.NotFoundException;
import com.sdelamer.midas.MidasChallenge.Mapper.ProductMapper;
import com.sdelamer.midas.MidasChallenge.Model.Product;
import com.sdelamer.midas.MidasChallenge.Repository.ProductRepository;
import com.sdelamer.midas.MidasChallenge.Service.ProductService;

@Service
public class ProductServiceImplementation implements ProductService {

	@Autowired
	ProductRepository productRepository;
	@Autowired
	ProductMapper productMapper;

	@Override
	public List<Product> findAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product findProductById(Long id) throws NotFoundException {
		Optional<Product> productById = productRepository.findById(id);

		if (productById.isPresent()) {
			return productById.get();
		} else {
			throw new NotFoundException("Product with Id " + "" + id + " not found");
		}

	}

	@Override
	public ProductDto updateProduct(Long id, ProductDto productDto) throws NotFoundException{
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Product does not exist."));
		product.setName(productDto.getName());
		product.setCount(productDto.getCount());
		product.setPrice(productDto.getPrice());
		productRepository.save(product);

		return productMapper.productToProductDto(product);
	}

	@Override
	public void deleteProductById(Long id) throws NotFoundException {
		if (!productRepository.existsById(id)) {
			throw new NotFoundException("Product with id " + id + " not found");
		}
		productRepository.deleteById(id);

	}

	@Override
	public Product save(ProductDto productDto) {
		Product newProduct = productMapper.productDtoToProduct(productDto);
		productRepository.save(newProduct); 
		return newProduct;
	}

}
