package com.brunomedeiros.juju_market.domain.enums

enum class PaymentMethodEnum private constructor(private val discount: Double, private val message: String) {
	CREDIT_CARD(1.0, "I was charged full price for paying with a credit card."),
	DEBIT_CARD(0.9, "Got 10% discount for paying with debit card."),
	MONEY(0.85, "Got 15% discount for paying with money."),
	PIX(0.9, "Got 10% discount for paying with PIX.");

	fun getDiscount(): Double = discount

	fun getMessage(): String = message
}