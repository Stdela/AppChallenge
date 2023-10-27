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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RequestMapping("/products")
@RestController
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "User", description = "The User API. Contains all the operations that can be performed on a user.")
public class ProductController {

	@Autowired
	ProductService productService;

	@Operation(summary = "Gets all products")
	@GetMapping
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Found products", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = ProductDto.class)) }) })
	public ResponseEntity<List<Product>> getAllProducts() {
		return new ResponseEntity<>(productService.findAllProducts(), HttpStatus.OK);
	}

	@Operation(summary = "Creates a product ")
	@PostMapping
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Product created", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = ProductDto.class)) }) })

	public ResponseEntity<Product> createProduct(
			@Parameter(description = "body of product to create") @Valid @RequestBody ProductDto productDto) {
		return new ResponseEntity<>(productService.save(productDto), HttpStatus.OK);
	}

	@Operation(summary = "Get a product by its id")
	@GetMapping("/{id}")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Product found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Product.class)) }),
			@ApiResponse(responseCode = "404", description = "Product not found"), })
	public ResponseEntity<Product> getProductById(
			@Parameter(description = "id of product to be searched") @PathVariable Long id) throws NotFoundException {
		return new ResponseEntity<>(productService.findProductById(id), HttpStatus.OK);
	}

	@Operation(summary = "Delete a product by its id")

	@DeleteMapping("/{id}")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Product deleted"),
			@ApiResponse(responseCode = "404", description = "Product not found"), })
	public ResponseEntity<?> deleteProduct(
			@Parameter(description = "id of product to be deleted") @PathVariable Long id) throws NotFoundException {
		productService.deleteProductById(id);
		return new ResponseEntity<>("Product was successfully deleted .", HttpStatus.OK);
	}

	@Operation(summary = "Modifies a product by its id")
	@PutMapping("/{id}")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Product modified", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ProductDto.class)) }),
			@ApiResponse(responseCode = "400", description = "Product Not Found"), })
	public ResponseEntity<ProductDto> updateProduct(
			@Parameter(description = "Product to edit body") @RequestBody ProductDto productDto,
			@Parameter(description = "id of product to be edited") @PathVariable Long id) throws NotFoundException {
		return new ResponseEntity<ProductDto>(productService.updateProduct(id, productDto), HttpStatus.OK);
	}

}
