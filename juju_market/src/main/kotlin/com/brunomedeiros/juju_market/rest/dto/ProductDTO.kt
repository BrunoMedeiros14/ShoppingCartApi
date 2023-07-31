package com.brunomedeiros.juju_market.rest.dto

import com.brunomedeiros.juju_market.domain.entity.Category
import com.brunomedeiros.juju_market.domain.entity.Product
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive
import java.math.BigDecimal

data class ProductDTO(
		var id: Long?,
		@field:NotBlank(message = "Insert a valid name.")
		val productName: String?,
		@field:NotNull(message = "Insert a valid unit of measurement.")
		val measurementUnit: String?,
		@field:NotNull(message = "Insert a valid value.")
		@field:Positive(message = "Insert a positive value.")
		val unitPrice: BigDecimal?,
		@field:NotNull(message = "Insert a valid category.")
		val category: Category?
) {

	constructor() : this(null, null, null, null, null)

	fun toEntity(): Product = Product(id, productName!!, measurementUnit!!, unitPrice!!, category!!)
}