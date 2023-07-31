package com.brunomedeiros.juju_market.service.impl

import com.brunomedeiros.juju_market.domain.entity.Cart
import com.brunomedeiros.juju_market.domain.entity.Product
import com.brunomedeiros.juju_market.domain.entity.ProductCart
import com.brunomedeiros.juju_market.domain.repository.ProductCartRepository
import com.brunomedeiros.juju_market.exception.NotFoundException
import com.brunomedeiros.juju_market.rest.dto.ProductCartDTO
import com.brunomedeiros.juju_market.service.ICartService
import com.brunomedeiros.juju_market.service.IProductCartService
import com.brunomedeiros.juju_market.service.IProductService
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductCartService(private val productCartRepository: ProductCartRepository, private val cartService: ICartService, private val productService: IProductService) : IProductCartService {
	override fun addProductCart(productCartDTO: ProductCartDTO): ProductCart = verifyProductInDatabase(productCartDTO)
			.orElseGet { createProductCart(productCartDTO) }.let {
				it.quantity += productCartDTO.quantity
				productCartRepository.save(it)
			}

	override fun removeProductCart(productCartDTO: ProductCartDTO): ProductCart = verifyProductInDatabase(productCartDTO)
			.orElseThrow { NotFoundException("ProductCart not found.") }
			.run {
				quantity -= productCartDTO.quantity
				if (quantity <= 0) {
					quantity = 0
					productCartRepository.deleteById(this.id!!)
					return@run this
				}
				productCartRepository.save(this)
			}

	private fun verifyProductInDatabase(productCartDTO: ProductCartDTO): Optional<ProductCart> = productCartRepository
			.findByProductIdAndCartId(productCartDTO.productId, productCartDTO.cartId)

	private fun createProductCart(productCartDTO: ProductCartDTO): ProductCart = productCartDTO.run {
		val cart: Cart = cartService.findCartById(cartId)
		val product: Product = productService.findProductById(productId)
		productCartRepository.save(ProductCart(null, product, 0, product.unitPrice, cart))
	}
}