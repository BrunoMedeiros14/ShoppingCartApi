package com.brunomedeiros.juju_market.domain.repository

import com.brunomedeiros.juju_market.domain.entity.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<Product, Long>