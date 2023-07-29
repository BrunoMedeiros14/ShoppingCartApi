package com.brunomedeiros.juju_market.rest.dto

import com.brunomedeiros.juju_market.domain.entity.Category
import java.math.BigDecimal

data class ProductDTO(
		var id: Long,
		val productName: String?,
		val measurementUnit: String?,
		val unitPrice: BigDecimal?,
		val category: Category?
)