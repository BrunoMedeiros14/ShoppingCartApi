package com.brunomedeiros.juju_market.rest.dto

import com.brunomedeiros.juju_market.domain.entity.Category
import jakarta.validation.constraints.NotBlank

data class CategoryDTO(
		@field:NotBlank(message = "insert a valid category.")
		val categoryName: String
) {
	fun toEntity(): Category = Category(categoryName = categoryName)
}