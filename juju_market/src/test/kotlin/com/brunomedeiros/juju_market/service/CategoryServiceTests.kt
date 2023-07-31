package com.brunomedeiros.juju_market.service

import com.brunomedeiros.juju_market.domain.entity.Category
import com.brunomedeiros.juju_market.domain.repository.CategoryRepository
import com.brunomedeiros.juju_market.exception.NotFoundException
import com.brunomedeiros.juju_market.rest.dto.CategoryDTO
import com.brunomedeiros.juju_market.service.impl.CategoryService
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import java.util.*

@ExtendWith(MockKExtension::class)
class CategoryServiceTests {

	@MockK
	lateinit var categoryRepository: CategoryRepository
	@InjectMockKs
	lateinit var categoryService: CategoryService
	private var fakeCategory: Category = Category(1, "Alimentos")

	@Test
	fun checkingCategoryWasCreated() {

		val fakeDTO = CategoryDTO(fakeCategory.categoryName)
		every { categoryRepository.save(any()) } returns fakeCategory

		val actual: Category = categoryService.save(fakeDTO)

		Assertions.assertThat(actual).isNotNull
		Assertions.assertThat(actual).isSameAs(fakeCategory)
		verify(exactly = 1) { categoryRepository.save(any()) }
	}

	@Test
	fun checkingIfFindCategoryList() {

		val fakeDTO = CategoryDTO(fakeCategory.categoryName)
		every { categoryRepository.save(any()) } returns fakeCategory
		every { categoryRepository.findAll() } returns listOf(fakeCategory)

		val actual: Category = categoryService.save(fakeDTO)
		val allCategories: List<Category> = categoryService.findAllCategories()

		Assertions.assertThat(allCategories).hasSize(1)
		Assertions.assertThat(allCategories).isEqualTo(listOf(actual))
		verify(exactly = 1) { categoryRepository.findAll() }
	}

	@Test
	fun checkingIfReturnsErrorWhenSearchingListEmpty() {

		every { categoryRepository.findAll() } returns emptyList()

		val assertThrows: NotFoundException = assertThrows<NotFoundException> { categoryService.findAllCategories() }

		Assertions.assertThat(assertThrows.message).isEqualTo("Not found categories.")
		verify(exactly = 1) { categoryRepository.findAll() }
	}

	@Test
	fun searchingCategoryById() {

		every { categoryRepository.findById(fakeCategory.id!!) } returns Optional.of(fakeCategory)
		every { categoryRepository.findById(2) } returns Optional.empty()
		every { categoryRepository.delete(any()) } returns Unit

		val category = categoryService.deleteById(fakeCategory.id!!)
		assertThrows<NotFoundException> { categoryService.deleteById(2) }

		Assertions.assertThat(category).isEqualTo(Unit)
		verify(exactly = 2) { categoryRepository.findById(any()) }
		verify(exactly = 1) { categoryRepository.delete(any()) }
	}
}
