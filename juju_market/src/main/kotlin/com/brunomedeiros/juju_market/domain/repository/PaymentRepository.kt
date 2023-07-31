package com.brunomedeiros.juju_market.domain.repository

import com.brunomedeiros.juju_market.domain.entity.Payment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PaymentRepository : JpaRepository<Payment, Long>