package com.brunomedeiros.juju_market.rest.dto

import com.brunomedeiros.juju_market.domain.entity.Cart
import com.brunomedeiros.juju_market.domain.entity.Payment

class PaymentResponseDTO(
		var message: String,
		var payment: Payment?
) {
	constructor(cart: Cart) : this(cart.payment!!.paymentMethod!!.getMessage(), cart.payment)
}