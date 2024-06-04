package com.lulakssoft.produktdemo

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/produkte")
class ProduktController(private val produktService: ProduktService) {

    val logger: Logger = LoggerFactory.getLogger(ProduktController::class.java)

    @GetMapping
    fun getAllProdukts(): List<Produkt> {
        logger.info("Getting all products")
        return produktService.getAlleProdukte()
    }

    @PostMapping
    fun createProdukt(@RequestBody produkt: Produkt): ResponseEntity<Produkt> {
        val createdProdukt = produktService.createProdukt(produkt)
        if (createdProdukt.statusCode == HttpStatus.CREATED) {
            logger.info("Produkt created: $createdProdukt")
        } else {
            logger.error("Produkt not created: $createdProdukt")
        }
        return createdProdukt
    }

    @GetMapping("/{id}")
    fun getProduktById(@PathVariable id: Long): ResponseEntity<Any> {
        logger.info("Getting produkt with id: $id")
        val requestedItem = produktService.getProduktById(id)
        if (requestedItem.statusCode == HttpStatus.OK) {
            logger.info("Produkt found: $requestedItem")
        } else {
            logger.error("Produkt not found: $requestedItem")
        }
        return requestedItem
    }

    @DeleteMapping("/{id}")
    fun deleteProduktById(@PathVariable id: Long) {
        logger.info("Deleting produkt with id: $id")
        return produktService.deleteProduktById(id)
    }

    @PutMapping("/{id}")
    fun updateProdukt(@PathVariable id: Long,@RequestBody produkt: Produkt): ResponseEntity<Any> {
        logger.info("Updating produkt with id: $id")
        return produktService.updateProdukt(id, produkt)
    }
}