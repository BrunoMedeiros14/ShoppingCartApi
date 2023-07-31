package com.brunomedeiros.juju_market.service.impl

import com.brunomedeiros.juju_market.domain.entity.Category
import com.brunomedeiros.juju_market.domain.repository.CategoryRepository
import com.brunomedeiros.juju_market.exception.NotFoundException
import com.brunomedeiros.juju_market.rest.dto.CategoryDTO
import com.brunomedeiros.juju_market.service.ICategoryService
import org.springframework.stereotype.Service

@Service
class CategoryService(private val categoryRepository: CategoryRepository) : ICategoryService {
	override fun save(categoryDTO: CategoryDTO): Category = categoryRepository.save(categoryDTO.toEntity())

	override fun findAllCategories(): List<Category> = categoryRepository.findAll().ifEmpty {
		throw NotFoundException("Not found categories.")
	}

	private fun findCategoryById(id: Long): Category = categoryRepository.findById(id)
			.orElseThrow { NotFoundException("Category not found.") }

	override fun deleteById(id: Long) = categoryRepository.delete(findCategoryById(id))
}