package com.architecture.hexagonal.adapters.out

import com.architecture.hexagonal.adapters.out.repository.CustomerRepository
import com.architecture.hexagonal.application.ports.out.DeleteCustomerByIdOutPutPort
import org.springframework.stereotype.Component

@Component
class DeleteCustomerByIdAdapter(
    private val customerRepository: CustomerRepository
): DeleteCustomerByIdOutPutPort {
    override fun delete(id: String) {
        customerRepository.deleteById(id)
    }
}