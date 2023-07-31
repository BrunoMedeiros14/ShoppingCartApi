package com.brunomedeiros.juju_market.service

import com.brunomedeiros.juju_market.domain.entity.Cart

interface ICartService {
	fun createCart(): Cart

	fun findCartById(id: Long): Cart

	fun findAllCarts(): List<Cart>

	fun deleteCartById(id: Long): Unit
}