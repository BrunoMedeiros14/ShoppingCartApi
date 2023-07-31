package com.brunomedeiros.juju_market.domain.entity

import com.brunomedeiros.juju_market.domain.enums.PaymentMethodEnum
import com.brunomedeiros.juju_market.domain.enums.PaymentStatusEnum
import jakarta.persistence.*

@Entity(name = "tb_cart")
class Cart(
		@Id
		@Column(name = "id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		val id: Long? = null,

		@Enumerated(EnumType.STRING)
		@Column(name = "payment_status")
		val paymentStatus: PaymentStatusEnum = PaymentStatusEnum.AWAITING,

		@Enumerated(EnumType.STRING)
		@Column(name = "payment_method")
		val paymentMethod: PaymentMethodEnum? = null,

		@OneToMany(mappedBy = "cart")
		var productsCart: MutableList<ProductCart> = mutableListOf()
)
