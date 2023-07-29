package com.brunomedeiros.juju_market.service.impl

import com.brunomedeiros.juju_market.domain.entity.Product
import com.brunomedeiros.juju_market.domain.repository.ProductRepository
import com.brunomedeiros.juju_market.exception.NotFoundException
import com.brunomedeiros.juju_market.rest.dto.ProductDTO
import com.brunomedeiros.juju_market.service.IProductService
import org.springframework.stereotype.Service

@Service
class ProductService(private val productRepository: ProductRepository) : IProductService {
	override fun saveProduct(product: Product): Product = productRepository.save(product)

	override fun findAllProducts(): List<Product> = productRepository.findAll()

	override fun findProductById(id: Long): Product = productRepository.findById(id)
			.orElseThrow { NotFoundException("Product not found.") }

	override fun updateProduct(productDTO: ProductDTO): Product = findProductById(productDTO.id).let {
		saveProduct(Product(productDTO.id,
				productDTO.productName ?: it.productName,
				productDTO.measurementUnit ?: it.measurementUnit,
				productDTO.unitPrice ?: it.unitPrice,
				productDTO.category ?: it.category
		))
	}

	override fun deleteProductById(id: Long) = productRepository.delete(findProductById(id))
}