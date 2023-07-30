package com.brunomedeiros.juju_market.domain.repository

import com.brunomedeiros.juju_market.domain.entity.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : JpaRepository<Category, Long>