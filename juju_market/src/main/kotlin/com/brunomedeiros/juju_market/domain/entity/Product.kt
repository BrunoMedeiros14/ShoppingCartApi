package com.brunomedeiros.juju_market.domain.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity(name = "tb_product")
class Product(
		@Id
		@Column(name = "id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		val id: Long? = null,

		@Column(name = "product_name")
		val productName: String,

		@Column(name = "measurement_unit")
		val measurementUnit: String,

		@Column(name = "unit_price", precision = 6, scale = 2)
		val unitPrice: BigDecimal,

		@ManyToOne
		@JoinColumn(name = "category_id")
		val category: Category,

		@OneToMany(mappedBy = "product")
		val productsCart: List<ProductCart> = mutableListOf()
)