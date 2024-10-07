package com.architecture.hexagonal.application.ports.`in`

import com.architecture.hexagonal.application.core.domain.Customer

interface FindCustomerByIdInputPort {

    fun find(id: String ): Customer
}