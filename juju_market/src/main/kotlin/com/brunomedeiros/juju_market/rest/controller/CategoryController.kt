package com.brunomedeiros.juju_market.rest.controller

import com.brunomedeiros.juju_market.domain.entity.Category
import com.brunomedeiros.juju_market.rest.dto.CategoryDTO
import com.brunomedeiros.juju_market.service.impl.CategoryService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/api/v1/category"])
class CategoryController(private val categoryService: CategoryService) {

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	fun getAllCategories(): List<CategoryDTO> = categoryService.findAllCategories().map { category -> CategoryDTO(category) }

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	fun save(@RequestBody @Valid category: Category): CategoryDTO = CategoryDTO(categoryService.save(category))

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	fun delete(@PathVariable id: Long) = categoryService.deleteById(id)

}