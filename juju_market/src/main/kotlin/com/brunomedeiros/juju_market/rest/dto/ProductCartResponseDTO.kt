package com.brunomedeiros.juju_market.rest.dto

import com.brunomedeiros.juju_market.domain.entity.Product
import com.brunomedeiros.juju_market.domain.entity.ProductCart
import java.math.BigDecimal

data class ProductCartResponseDTO(
		val id: Long?,
		val product: Product,
		val quantity: Int,
		val salePrice: BigDecimal,
		val totalPrice: BigDecimal = salePrice.multiply(BigDecimal(quantity)),
) {
	constructor(productCart: ProductCart) : this(productCart.id, productCart.product, productCart.quantity, productCart.salePrice)
}