package com.brunomedeiros.juju_market.domain.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

@Entity(name = "tb_product")
class Product(
		@Id
		@Column(name = "id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		var id: Long,

		@Column(name = "product_name")
		@NotEmpty(message = "Insert a valid name.")
		val productName: String,

		@Column(name = "measurement_unit")
		@NotEmpty(message = "Insert a valid unit of measurement.")
		val measurementUnit: String,

		@NotNull(message = "Insert a valid value")
		@Column(name = "unit_price", precision = 6, scale = 2)
		val unitPrice: BigDecimal,

		@ManyToOne
		@JoinColumn(name = "category_id")
		val category: Category
)