package com.architecture.hexagonal.adapters.out

import com.architecture.hexagonal.adapters.out.repository.CustomerRepository
import com.architecture.hexagonal.adapters.out.repository.entity.CustomerEntity
import com.architecture.hexagonal.application.core.domain.Customer
import com.architecture.hexagonal.application.ports.out.UpdateCustomerOutPutPort
import org.springframework.stereotype.Component

@Component
class UpdateCustomerAdapter(
    private val customerRepository : CustomerRepository
): UpdateCustomerOutPutPort{
    override fun update(customer: Customer) {
        customerRepository.save(CustomerEntity(customer))
    }
}

