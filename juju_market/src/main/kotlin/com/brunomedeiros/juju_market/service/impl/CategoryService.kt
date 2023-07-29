package com.brunomedeiros.juju_market.service.impl

import com.brunomedeiros.juju_market.domain.entity.Category
import com.brunomedeiros.juju_market.domain.repository.CategoryRepository
import com.brunomedeiros.juju_market.service.ICategoryService
import org.springframework.stereotype.Service

@Service
class CategoryService(private val categoryRepository: CategoryRepository) : ICategoryService {
	override fun save(category: Category): Category = categoryRepository
			.findByCategoryName(category.categoryName)
			.orElseGet { categoryRepository.save(category) }

	override fun findAllCategories(): List<Category> = categoryRepository.findAll()
	override fun deleteById(id: Long) = categoryRepository.deleteById(id)
}