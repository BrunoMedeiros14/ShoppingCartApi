package com.brunomedeiros.juju_market.rest.dto

import com.brunomedeiros.juju_market.domain.entity.Category
import com.brunomedeiros.juju_market.domain.entity.Product
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

data class ProductDTO(
		var id: Long?,
		@NotEmpty(message = "Insert a valid name.")
		val productName: String?,
		@NotEmpty(message = "Insert a valid unit of measurement.")
		val measurementUnit: String?,
		@NotNull(message = "Insert a valid value")
		val unitPrice: BigDecimal?,
		@NotNull(message = "Insert a valid category")
		val category: Category?
) {
	fun toEntity(): Product = Product(id, productName!!, measurementUnit!!, unitPrice!!, category!!)
}