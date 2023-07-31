package com.brunomedeiros.juju_market.domain.enums

enum class PaymentMethodEnum private constructor(private val discount: Double) {
	CREDIT_CARD(1.0),
	DEBIT_CARD(0.9),
	MONEY(0.85),
	PIX(0.9);

	fun getDiscount(): Double = discount
}