package com.architecture.hexagonal.application.ports.`in`

import com.architecture.hexagonal.application.core.domain.Customer

interface UpdateCustomerInputPort {
    fun Update(customer: Customer, zipCode: String)
}