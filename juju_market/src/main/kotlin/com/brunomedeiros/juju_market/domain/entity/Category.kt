package com.brunomedeiros.juju_market.domain.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import jakarta.validation.constraints.NotEmpty

@Entity(name = "tb_category")
class Category(
		@Id
		@Column(name = "id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		var id: Long,
		@NotEmpty(message = "Insert a valid category, not empty.")
		@Column(name = "category_name", unique = true)
		var categoryName: String,
		@JsonIgnore
		@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
		var productList: List<Product> = mutableListOf()
)