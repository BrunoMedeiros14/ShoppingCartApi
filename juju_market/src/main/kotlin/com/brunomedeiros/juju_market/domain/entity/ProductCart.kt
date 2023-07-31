package com.brunomedeiros.juju_market.domain.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.math.BigDecimal

@Entity(name = "tb_product_cart")
class ProductCart(
		@Id
		@Column(name = "id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		val id: Long? = null,

		@ManyToOne
		@JoinColumn(name = "product_id")
		val product: Product,

		@Column(name = "quantity")
		var quantity: Int,

		@Column(name = "acquisition_price", precision = 20, scale = 2)
		val salePrice: BigDecimal,

		@ManyToOne
		@JsonIgnore
		@JoinColumn(name = "cart_id")
		val cart: Cart
)