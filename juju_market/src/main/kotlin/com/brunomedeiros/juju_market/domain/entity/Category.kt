package com.brunomedeiros.juju_market.domain.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity(name = "tb_category")
class Category(
		@Id
		@Column(name = "id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		val id: Long? = null,

		@Column(name = "category_name", unique = true)
		val categoryName: String,

		@JsonIgnore
		@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
		val productList: List<Product> = mutableListOf()
)