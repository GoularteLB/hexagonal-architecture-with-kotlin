package com.architecture.hexagonal.adapters.out

import com.architecture.hexagonal.adapters.out.repository.CustomerRepository
import com.architecture.hexagonal.adapters.out.repository.entity.CustomerEntity
import com.architecture.hexagonal.application.core.domain.Customer
import com.architecture.hexagonal.application.ports.out.InsertCustomerOutputPort
import org.springframework.stereotype.Component

@Component
class InsertCustomerAdapter(
    private val customerRepository: CustomerRepository
): InsertCustomerOutputPort {
    override fun insert(customer: Customer) {
        customerRepository.save(CustomerEntity(customer))
    }

}