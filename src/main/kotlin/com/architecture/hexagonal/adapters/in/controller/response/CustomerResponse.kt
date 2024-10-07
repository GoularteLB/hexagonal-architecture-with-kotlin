package com.architecture.hexagonal.adapters.`in`.controller.response

import com.architecture.hexagonal.application.core.domain.Customer

data class CustomerResponse(
    val id: String,
    val name: String,
    val address: AddressResponse,
    val cpf: String,
    val IsValidCpf: Boolean
){
    constructor(customer: Customer): this(
        customer.id!!,
        customer.name,
        AddressResponse(customer.address!!),
        customer.cpf,
        customer.isValidCpf
    )
}