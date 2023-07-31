package com.brunomedeiros.juju_market.rest

data class ApiErrors(
		val messageList: List<String?>,
		val error: Boolean = true
) {
	constructor(message: String?) : this(messageList = listOf(message))
}