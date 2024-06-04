package com.lulakssoft.produktdemo

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ProduktDemoApplication

val logger: Logger = LoggerFactory.getLogger(ProduktDemoApplication::class.java)

fun main(args: Array<String>) {
    val application = runApplication<ProduktDemoApplication>(*args)
    logger.info("ProduktDemoApplication startup complete")

    if (application.isRunning) {
        logger.info("Application is running")
    } else {
        logger.error("Application is not running")
    }
}
