package com.brunomedeiros.juju_market.rest

import com.brunomedeiros.juju_market.exception.NotFoundException
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ControllerAdivice {
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	@ExceptionHandler(DataIntegrityViolationException::class)
	fun handleRegraNegocioException(ex: DataIntegrityViolationException): ApiErrors = ApiErrors(ex.cause?.message)

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NotFoundException::class)
	fun handleResponseStatusException(ex: NotFoundException): ApiErrors = ApiErrors(ex.message)

}