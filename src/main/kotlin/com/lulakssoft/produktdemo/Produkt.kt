package com.lulakssoft.produktdemo

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Produkt(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var name: String = "",
    var price: Double = 0.0,
    var description: String = "",
    var category: String = "Sonstiges",
    var stock: Int = 0
)
