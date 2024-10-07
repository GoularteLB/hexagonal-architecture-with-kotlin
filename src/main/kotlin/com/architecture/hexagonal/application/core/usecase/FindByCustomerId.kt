package com.architecture.hexagonal.application.core.usecase

import com.architecture.hexagonal.application.core.domain.Customer
import com.architecture.hexagonal.application.core.exceptions.ObjectNotFoundException
import com.architecture.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import com.architecture.hexagonal.application.ports.out.FindByCustomerIdOutPutPort

class FindByCustomerId(
    private val findByCustomerIdOutPutPort: FindByCustomerIdOutPutPort
): FindCustomerByIdInputPort {
    override fun find(id: String): Customer{
        return findByCustomerIdOutPutPort.find(id) ?: throw ObjectNotFoundException("Customer not found")
    }
}