package com.brunomedeiros.juju_market.rest.dto

import com.brunomedeiros.juju_market.domain.entity.Cart
import com.brunomedeiros.juju_market.domain.enums.PaymentMethodEnum
import com.brunomedeiros.juju_market.domain.enums.PaymentStatusEnum
import java.math.BigDecimal

data class CartResponseDTO(
		val id: Long?,
		val paymentStatus: PaymentStatusEnum?,
		val paymentMethod: PaymentMethodEnum?,
		val productsCart: List<ProductCartResponseDTO>,
		val totalPrice: BigDecimal = productsCart.sumOf { it.totalPrice }
) {
	constructor(cart: Cart) : this(cart.id, cart.paymentStatus, cart.paymentMethod, cart.productsCart.map { ProductCartResponseDTO(it) })
}