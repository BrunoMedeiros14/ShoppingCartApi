package com.brunomedeiros.juju_market.rest.dto

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.PositiveOrZero

data class ProductCartDTO(
		@field:NotNull(message = "Insert a valid product id.")
		val productId: Long,
		@field:NotNull(message = "Insert a integer value.")
		@field:PositiveOrZero(message = "Insert a positive number a this value.")
		val quantity: Int = 1,
		@field:NotNull(message = "Insert a valid cart id.")
		var cartId: Long
)