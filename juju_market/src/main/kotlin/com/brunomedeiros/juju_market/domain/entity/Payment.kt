package com.brunomedeiros.juju_market.domain.entity

import com.brunomedeiros.juju_market.domain.enums.PaymentMethodEnum
import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity(name = "tb_payment")
class Payment(

		@Id
		@Column(name = "id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		val id: Long? = null,

		@Enumerated(EnumType.STRING)
		@Column(name = "payment_method")
		val paymentMethod: PaymentMethodEnum? = null,

		@JsonFormat(pattern = "yyyy-MM-dd")
		@Column(name = "payment_date")
		val paymentDate: LocalDateTime,

		@Column(name = "final_price", precision = 6, scale = 2)
		val finalPrice: BigDecimal
)