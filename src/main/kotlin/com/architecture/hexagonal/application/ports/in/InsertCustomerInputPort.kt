package com.architecture.hexagonal.application.ports.`in`

import com.architecture.hexagonal.application.core.domain.Customer

interface InsertCustomerInputPort {
    fun insert(customer: Customer, zipCode: String)
}