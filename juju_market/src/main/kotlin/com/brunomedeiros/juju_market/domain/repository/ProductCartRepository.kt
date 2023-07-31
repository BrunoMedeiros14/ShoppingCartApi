package com.brunomedeiros.juju_market.domain.repository

import com.brunomedeiros.juju_market.domain.entity.ProductCart
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProductCartRepository : JpaRepository<ProductCart, Long> {

	fun findByProductIdAndCartId(productId: Long, cartId: Long): Optional<ProductCart>
}