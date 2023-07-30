package com.brunomedeiros.juju_market.service

import com.brunomedeiros.juju_market.domain.entity.Category
import com.brunomedeiros.juju_market.rest.dto.CategoryDTO

interface ICategoryService {
	fun findAllCategories(): List<Category>
	fun deleteById(id: Long)
	fun save(categoryDTO: CategoryDTO): Category
}