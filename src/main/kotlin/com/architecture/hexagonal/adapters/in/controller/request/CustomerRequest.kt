package com.architecture.hexagonal.adapters.`in`.controller.request

import jakarta.validation.constraints.NotBlank

data class CustomerRequest(
    @field:NotBlank(message = "Name must not be blank")
    val name : String,
    @field:NotBlank(message = "cpf must not be blank")
    val cpf : String,
    @field:NotBlank(message = "zip code must not be blank")
    val zipCode: String
)
