package com.brunomedeiros.juju_market.service

import com.brunomedeiros.juju_market.domain.entity.ProductCart
import com.brunomedeiros.juju_market.rest.dto.ProductCartDTO

interface IProductCartService {
	fun addProductCart(productCartDTO: ProductCartDTO): ProductCart
	fun removeProductCart(productCartDTO: ProductCartDTO): ProductCart
}