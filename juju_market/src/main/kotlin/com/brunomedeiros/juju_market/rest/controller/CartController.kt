package com.brunomedeiros.juju_market.rest.controller

import com.brunomedeiros.juju_market.domain.enums.PaymentMethodEnum
import com.brunomedeiros.juju_market.rest.dto.CartResponseDTO
import com.brunomedeiros.juju_market.rest.dto.PaymentResponseDTO
import com.brunomedeiros.juju_market.service.ICartService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/api/v1/cart"])
class CartController(private val cartService: ICartService) {

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	fun getAllCarts(): List<CartResponseDTO> = cartService.findAllCarts().map { CartResponseDTO(it) }

	@GetMapping("/{cartId}")
	@ResponseStatus(HttpStatus.OK)
	fun findCartById(@PathVariable cartId: Long): CartResponseDTO = CartResponseDTO(cartService.findCartById(cartId))

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	fun createCart(): CartResponseDTO = CartResponseDTO(cartService.createCart())

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	fun delete(@PathVariable id: Long) = cartService.deleteCartById(id)

	@PostMapping("/pay")
	@ResponseStatus(HttpStatus.OK)
	fun payCart(@RequestParam id: Long, @RequestParam paymentMethod: PaymentMethodEnum): PaymentResponseDTO =
			PaymentResponseDTO(cartService.cartPay(id, paymentMethod))
}