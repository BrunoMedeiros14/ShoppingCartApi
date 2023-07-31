package com.brunomedeiros.juju_market.domain.entity

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
		var paymentStatus: PaymentStatusEnum = PaymentStatusEnum.AWAITING,

		@OneToMany(mappedBy = "cart")
		var productsCart: MutableList<ProductCart> = mutableListOf(),

		@OneToOne(cascade = [CascadeType.ALL])
		@JoinColumn(name = "payment_id", unique = true)
		var payment: Payment? = null
)
