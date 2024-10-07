package com.architecture.hexagonal.application.ports.out

import com.architecture.hexagonal.application.core.domain.Customer

interface FindByCustomerIdOutPutPort {
    fun find(id: String): Customer?
}