package com.architecture.hexagonal.adapters.out.repository.entity

import com.architecture.hexagonal.application.core.domain.Customer
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.MongoId

@Document(collation = "customer")
data class CustomerEntity(
    @MongoId val id : String?,
    val name : String,
    var address: AddressEntity,
    val cpf : String,
    val isValidCpf: Boolean,
){
    constructor(customer: Customer): this(
        customer.id,
        customer.name,
        AddressEntity(customer.address!!),
        customer.cpf,
        customer.isValidCpf

    )
    fun toCustomer() = Customer(id, name, address.toAddress(), cpf, isValidCpf)
}
