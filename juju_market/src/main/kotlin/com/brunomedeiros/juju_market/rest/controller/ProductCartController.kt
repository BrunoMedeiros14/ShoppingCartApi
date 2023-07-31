package com.brunomedeiros.juju_market.rest.controller

import com.brunomedeiros.juju_market.rest.dto.ProductCartDTO
import com.brunomedeiros.juju_market.rest.dto.ProductCartResponseDTO
import com.brunomedeiros.juju_market.service.IProductCartService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/api/v1/product_cart"])
class ProductCartController(private val productCartService: IProductCartService) {

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	fun addProductCart(@RequestBody @Valid productCartDTO: ProductCartDTO): ProductCartResponseDTO =
			ProductCartResponseDTO(productCartService.addProductCart(productCartDTO))

	@PatchMapping
	@ResponseStatus(HttpStatus.OK)
	fun removeProductCart(@RequestBody @Valid productCartDTO: ProductCartDTO): ProductCartResponseDTO =
			ProductCartResponseDTO(productCartService.removeProductCart(productCartDTO))
}