package com.brunomedeiros.juju_market.rest.dto

import com.brunomedeiros.juju_market.domain.entity.Category

data class CategoryDTO(
		val id: Long,
		val categoryName: String
) {
	constructor(category: Category) : this(category.id, category.categoryName)
}