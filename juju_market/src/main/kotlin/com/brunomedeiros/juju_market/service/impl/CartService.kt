package com.brunomedeiros.juju_market.service.impl

import com.brunomedeiros.juju_market.domain.entity.Cart
import com.brunomedeiros.juju_market.domain.repository.CartRepository
import com.brunomedeiros.juju_market.exception.NotFoundException
import com.brunomedeiros.juju_market.service.ICartService
import org.springframework.stereotype.Service

@Service
class CartService(private val cartRepository: CartRepository) : ICartService {

	override fun createCart(): Cart = cartRepository.save(Cart())

	override fun findCartById(id: Long): Cart = cartRepository.findById(id)
			.orElseThrow { NotFoundException("Cart not found.") }

	override fun findAllCarts(): List<Cart> = cartRepository.findAll()
			.ifEmpty { throw NotFoundException("Not found carts.") }

	override fun deleteCartById(id: Long): Unit = cartRepository.deleteById(id)

}