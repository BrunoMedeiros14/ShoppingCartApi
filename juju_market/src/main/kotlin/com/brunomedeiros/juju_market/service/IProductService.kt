package com.brunomedeiros.juju_market.service

import com.brunomedeiros.juju_market.domain.entity.Product
import com.brunomedeiros.juju_market.rest.dto.ProductDTO

interface IProductService {
	fun saveProduct(productDTO: ProductDTO): Product
	fun findAllProducts(): List<Product>
	fun findProductById(id: Long): Product
	fun updateProduct(id: Long, productDTO: ProductDTO): Product
	fun deleteProductById(id: Long)
}