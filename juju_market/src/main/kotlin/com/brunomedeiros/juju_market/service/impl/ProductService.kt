package com.brunomedeiros.juju_market.service.impl

import com.brunomedeiros.juju_market.domain.entity.Product
import com.brunomedeiros.juju_market.domain.repository.ProductRepository
import com.brunomedeiros.juju_market.exception.NotFoundException
import com.brunomedeiros.juju_market.rest.dto.ProductDTO
import com.brunomedeiros.juju_market.service.IProductService
import org.springframework.stereotype.Service

@Service
class ProductService(private val productRepository: ProductRepository) : IProductService {
	override fun saveProduct(productDTO: ProductDTO): Product = productRepository.save(productDTO.toEntity())

	override fun findAllProducts(): List<Product> = productRepository.findAll().ifEmpty {
		throw NotFoundException("Not found products.")
	}

	override fun findProductById(id: Long): Product = productRepository.findById(id)
			.orElseThrow { NotFoundException("Product not found.") }

	override fun updateProduct(id: Long, productDTO: ProductDTO): Product = findProductById(id).let {
		saveProduct(ProductDTO(id,
				productDTO.productName ?: it.productName,
				productDTO.measurementUnit ?: it.measurementUnit,
				productDTO.unitPrice ?: it.unitPrice,
				productDTO.category ?: it.category
		))
	}

	override fun deleteProductById(id: Long) = productRepository.delete(findProductById(id))
}