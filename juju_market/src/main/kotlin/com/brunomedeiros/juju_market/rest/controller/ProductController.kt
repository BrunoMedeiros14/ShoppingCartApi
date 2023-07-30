package com.brunomedeiros.juju_market.rest.controller

import com.brunomedeiros.juju_market.rest.dto.ProductDTO
import com.brunomedeiros.juju_market.service.IProductService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/api/v1/product"])
class ProductController(private val productService: IProductService) {

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	fun getAllProducts(): List<ProductDTO> = productService.findAllProducts().map {
		ProductDTO(it.id, it.productName, it.measurementUnit, it.unitPrice, it.category)
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	fun getById(@PathVariable id: Long): ProductDTO = productService.findProductById(id).run {
		ProductDTO(id, productName, measurementUnit, unitPrice, category)
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	fun saveProduct(@RequestBody @Valid productDTO: ProductDTO): ProductDTO = productService.saveProduct(productDTO).run {
		ProductDTO(id, productName, measurementUnit, unitPrice, category)
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	fun updateProduct(@PathVariable id: Long, @RequestBody productDTO: ProductDTO): ProductDTO = productService.updateProduct(id, productDTO).run {
		ProductDTO(id, productName, measurementUnit, unitPrice, category)
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	fun deleteProduct(@PathVariable id: Long) = productService.deleteProductById(id)
}