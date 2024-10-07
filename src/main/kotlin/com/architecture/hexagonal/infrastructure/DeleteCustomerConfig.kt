package com.architecture.hexagonal.infrastructure

import com.architecture.hexagonal.adapters.out.DeleteCustomerByIdAdapter
import com.architecture.hexagonal.application.core.usecase.DeleteCustomerById
import com.architecture.hexagonal.application.core.usecase.FindByCustomerId
import com.architecture.hexagonal.application.ports.`in`.DeleteCustomerByIdInputPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DeleteCustomerConfig {

    @Bean
    fun deleteCustomer(
        findByCustomerId: FindByCustomerId,
        deleteCustomerByIdAdapter: DeleteCustomerByIdAdapter
    ): DeleteCustomerByIdInputPort{
        return DeleteCustomerById(findByCustomerId, deleteCustomerByIdAdapter)
    }
}