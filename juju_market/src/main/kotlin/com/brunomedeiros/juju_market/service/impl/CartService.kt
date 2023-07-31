package com.brunomedeiros.juju_market.service.impl

import com.brunomedeiros.juju_market.domain.entity.Cart
import com.brunomedeiros.juju_market.domain.entity.Payment
import com.brunomedeiros.juju_market.domain.enums.PaymentMethodEnum
import com.brunomedeiros.juju_market.domain.enums.PaymentStatusEnum
import com.brunomedeiros.juju_market.domain.repository.CartRepository
import com.brunomedeiros.juju_market.domain.repository.PaymentRepository
import com.brunomedeiros.juju_market.exception.NotFoundException
import com.brunomedeiros.juju_market.service.ICartService
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.time.LocalDateTime

@Service
class CartService(private val cartRepository: CartRepository, private val paymentRepository: PaymentRepository) : ICartService {

	override fun createCart(): Cart = cartRepository.save(Cart())

	override fun findCartById(id: Long): Cart = cartRepository.findById(id)
			.orElseThrow { NotFoundException("Cart not found.") }

	override fun findValidCartById(id: Long): Cart = findCartById(id).let {
		if (it.paymentStatus == PaymentStatusEnum.FINISHED)
			throw IllegalArgumentException("cart already finished.", Throwable())
		it
	}

	override fun findAllCarts(): List<Cart> = cartRepository.findAll()
			.ifEmpty { throw NotFoundException("Not found carts.") }

	override fun deleteCartById(id: Long): Unit = cartRepository.deleteById(id)

	override fun cartPay(id: Long, paymentMethod: PaymentMethodEnum): Cart = findValidCartById(id).run {
		paymentStatus = PaymentStatusEnum.FINISHED
		payment = createPayment(this, paymentMethod)
		cartRepository.save(this)
	}

	private fun createPayment(cart: Cart, paymentMethod: PaymentMethodEnum): Payment {

		val finalPrice = cart.productsCart.sumOf { it.salePrice.multiply(BigDecimal(it.quantity)) }.multiply(BigDecimal.valueOf(paymentMethod.getDiscount()))

		return paymentRepository.save(Payment(null, paymentMethod, LocalDateTime.now(), finalPrice))
	}

}