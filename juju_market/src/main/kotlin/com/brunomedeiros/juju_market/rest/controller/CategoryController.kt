package com.brunomedeiros.juju_market.rest.controller

import com.brunomedeiros.juju_market.rest.dto.CategoryDTO
import com.brunomedeiros.juju_market.rest.dto.CategoryResponseDTO
import com.brunomedeiros.juju_market.service.ICategoryService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/api/v1/category"])
class CategoryController(private val categoryService: ICategoryService) {

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	fun getAllCategories(): List<CategoryResponseDTO> = categoryService.findAllCategories().map { CategoryResponseDTO(it) }

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	fun save(@RequestBody @Valid categoryDTO: CategoryDTO): CategoryResponseDTO = CategoryResponseDTO(categoryService.save(categoryDTO))

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	fun delete(@PathVariable id: Long) = categoryService.deleteById(id)

}