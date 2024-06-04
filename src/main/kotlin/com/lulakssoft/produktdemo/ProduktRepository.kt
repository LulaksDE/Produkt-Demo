package com.lulakssoft.produktdemo

import org.springframework.data.jpa.repository.JpaRepository

interface ProduktRepository : JpaRepository<Produkt, Long>