package com.brunomedeiros.juju_market.service

import com.brunomedeiros.juju_market.domain.entity.Category

interface ICategoryService {
	fun save(category: Category): Category
	fun findAllCategories(): List<Category>
	fun deleteById(id: Long)
}