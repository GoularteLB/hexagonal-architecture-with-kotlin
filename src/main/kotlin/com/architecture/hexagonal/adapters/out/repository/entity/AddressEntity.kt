package com.architecture.hexagonal.adapters.out.repository.entity

import com.architecture.hexagonal.application.core.domain.Address

data class AddressEntity(
    val street: String,
    val city: String,
    val state: String
){
    constructor(address: Address): this(
        address.street,
        address.city,
        address.state
    )
    fun toAddress() = Address(street, city, state)
}
