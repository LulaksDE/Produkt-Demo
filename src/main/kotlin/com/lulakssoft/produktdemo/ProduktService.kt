package com.lulakssoft.produktdemo

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class ProduktService(private val produktRepository: ProduktRepository) {

    fun getAlleProdukte(): List<Produkt> {
        return produktRepository.findAll()
    }

    fun createProdukt(produkt: Produkt): ResponseEntity<Produkt> {
        return ResponseEntity.status(201).body(produktRepository.save(produkt))
    }

    fun getProduktById(id: Long): ResponseEntity<Any> {
        val produkt = produktRepository.findById(id)
        return if (produkt.isPresent) {
            ResponseEntity.ok(produkt.get())
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produkt mit ID $id nicht gefunden")
        }
    }

    fun deleteProduktById(id: Long) {
        produktRepository.deleteById(id)
    }

    fun updateProdukt(id: Long, produktDaten: Produkt): ResponseEntity<Any> {
        val produkt = produktRepository.findById(id)
        return if (produkt.isPresent) {
            val existingProdukt = produkt.get()
            existingProdukt.name = produktDaten.name
            existingProdukt.price = produktDaten.price
            existingProdukt.description = produktDaten.description
            existingProdukt.category = produktDaten.category
            existingProdukt.stock = produktDaten.stock
            ResponseEntity.ok(produktRepository.save(existingProdukt))
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produkt mit ID $id nicht gefunden")
        }
    }

}