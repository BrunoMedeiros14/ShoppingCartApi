package com.brunomedeiros.juju_market.rest.dto

import com.brunomedeiros.juju_market.domain.entity.Category

data class CategoryDTO(
		val categoryName: String
) {
	fun toEntity(): Category = Category(categoryName = categoryName)
}