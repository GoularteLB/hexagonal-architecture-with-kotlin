package com.architecture.hexagonal.adapters.out

import com.architecture.hexagonal.adapters.out.repository.CustomerRepository
import com.architecture.hexagonal.application.core.domain.Customer
import com.architecture.hexagonal.application.ports.out.FindByCustomerIdOutPutPort
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrNull

@Component
class FindCustomerByIdAdapter(
    private val customerRepository: CustomerRepository
): FindByCustomerIdOutPutPort {
    override fun find(id: String): Customer? {
        return customerRepository.findById(id)
            .getOrNull()
            .let {
                return it?.toCustomer()
            }
    }
}