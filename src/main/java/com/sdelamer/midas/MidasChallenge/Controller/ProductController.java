package com.sdelamer.midas.MidasChallenge.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdelamer.midas.MidasChallenge.Dto.ProductDto;
import com.sdelamer.midas.MidasChallenge.Exception.NotFoundException;
import com.sdelamer.midas.MidasChallenge.Model.Product;
import com.sdelamer.midas.MidasChallenge.Service.ProductService;

@RequestMapping("/products")
@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping
//	TODO reemplazar x dto
	public ResponseEntity<List<Product>> getAllProducts() {
		return new ResponseEntity<>(productService.findAllProducts(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody ProductDto productDto) {
		return new ResponseEntity<>(productService.save(productDto)  , HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) throws NotFoundException {
		return new ResponseEntity<>(productService.findProductById(id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long id) throws NotFoundException {
		productService.deleteProductById(id);
		return new ResponseEntity<>("Product was successfully deleted .", HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto, @PathVariable Long id) {
		return new ResponseEntity<ProductDto>(productService.updateProduct(id, productDto), HttpStatus.CREATED);
	}

}
