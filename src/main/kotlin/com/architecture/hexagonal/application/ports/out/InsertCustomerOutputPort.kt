package com.architecture.hexagonal.application.ports.out

import com.architecture.hexagonal.application.core.domain.Customer

interface InsertCustomerOutputPort {
    fun insert(customer: Customer)
}