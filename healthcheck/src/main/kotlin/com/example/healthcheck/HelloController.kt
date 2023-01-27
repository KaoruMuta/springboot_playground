package com.example.healthcheck

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {
    @GetMapping("/hello")
    fun getHello(): Map<String, String> {
        return mapOf("Hello" to "World")
    }
}