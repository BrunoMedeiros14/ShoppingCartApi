package com.brunomedeiros.juju_market.service

import com.brunomedeiros.juju_market.domain.entity.Category
import com.brunomedeiros.juju_market.domain.entity.Product
import com.brunomedeiros.juju_market.domain.repository.ProductRepository
import com.brunomedeiros.juju_market.exception.NotFoundException
import com.brunomedeiros.juju_market.rest.dto.ProductDTO
import com.brunomedeiros.juju_market.service.impl.ProductService
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import java.math.BigDecimal
import java.util.*

@ExtendWith(MockKExtension::class)
class ProductServiceTests {

	@MockK
	lateinit var productRepository: ProductRepository

	@InjectMockKs
	lateinit var productService: ProductService

	private var fakeCategory: Category = Category(1, "Limpeza")
	private var fakeProduct = Product(1, "Vassoura", "un", BigDecimal(10), fakeCategory)

	@Test
	fun checkingIfProductWasCreated() {

		val fakeProductDTO = ProductDTO(2, "Rodo", "un", BigDecimal(11), fakeCategory)
		val product = fakeProductDTO.toEntity()
		every { productRepository.save(any()) } returns product

		val actual: Product = productService.saveProduct(fakeProductDTO)

		Assertions.assertThat(actual).isNotNull
		Assertions.assertThat(actual).isEqualTo(product)
		verify(exactly = 1) { productRepository.save(any()) }
	}

	@Test
	fun checkingIfFindProductList() {

		val fakeProductDTO = ProductDTO(2, "Rodo", "un", BigDecimal(11), fakeCategory)
		val product = fakeProductDTO.toEntity()
		every { productRepository.save(any()) } returns product
		every { productRepository.findAll() } returns listOf(product)

		val actual: Product = productService.saveProduct(fakeProductDTO)
		val allProducts: List<Product> = productService.findAllProducts()

		Assertions.assertThat(allProducts).hasSize(1)
		Assertions.assertThat(allProducts).isEqualTo(listOf(actual))
		verify(exactly = 1) { productRepository.save(any()) }
		verify(exactly = 1) { productRepository.findAll() }
	}

	@Test
	fun checkingIfReturnsErrorWhenFetchingEmptyProductList() {

		every { productRepository.findAll() } returns emptyList()

		val assertThrows: NotFoundException = assertThrows<NotFoundException> { productService.findAllProducts() }

		Assertions.assertThat(assertThrows.message).isEqualTo("Not found products.")
		verify(exactly = 1) { productRepository.findAll() }
	}

	@Test
	fun searchingProductByIdExcluding() {

		every { productRepository.findById(fakeCategory.id!!) } returns Optional.of(fakeProduct)
		every { productRepository.findById(2) } returns Optional.empty()
		every { productRepository.delete(any()) } returns Unit

		val actual = productService.deleteProductById(fakeProduct.id!!)
		assertThrows<NotFoundException> { productService.deleteProductById(2) }

		Assertions.assertThat(actual).isEqualTo(Unit)
		verify(exactly = 2) { productRepository.findById(any()) }
		verify(exactly = 1) { productRepository.delete(any()) }
	}

	@Test
	fun updatingProduct() {
		val fakeProductDTO = ProductDTO(2, "Rodo", "un", BigDecimal(11), fakeCategory)
		val fakeProductDTO2 = ProductDTO(2, "Vassoura", "un", BigDecimal(12), fakeCategory)
		val product = fakeProductDTO.toEntity()
		val productToUpdate = fakeProductDTO.toEntity()
		every { productRepository.findById(2) } returns Optional.of(product)
		every { productRepository.findById(3) } returns Optional.empty()
		every { productRepository.save(any()) } returns productToUpdate

		val returnedProduct = productService.findProductById(2)
		val assertThrows = assertThrows<NotFoundException> { productService.findProductById(3) }
		val updatedProduct = productService.updateProduct(2, fakeProductDTO2)

		Assertions.assertThat(returnedProduct).isNotNull
		Assertions.assertThat(updatedProduct).isNotNull
		Assertions.assertThat(assertThrows.message).isEqualTo("Product not found.")
		Assertions.assertThat(returnedProduct).isEqualTo(product)
		Assertions.assertThat(updatedProduct).isEqualTo(productToUpdate)
		verify(exactly = 1) { productRepository.save(any()) }
		verify(exactly = 2) { productRepository.findById(2) }
		verify(exactly = 1) { productRepository.findById(3) }
	}
}