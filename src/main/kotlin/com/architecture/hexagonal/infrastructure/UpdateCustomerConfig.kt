package com.architecture.hexagonal.infrastructure

import com.architecture.hexagonal.adapters.out.FindCustomerByIdAdapter
import com.architecture.hexagonal.adapters.out.UpdateCustomerAdapter
import com.architecture.hexagonal.application.core.usecase.FindByCustomerId
import com.architecture.hexagonal.application.ports.`in`.UpdateCustomerInputPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UpdateCustomerConfig {
    @Bean
    fun UpdateCustomer(
        findCustomerById: FindByCustomerId,
        findAddressByIdAdapter: FindCustomerByIdAdapter,
        updateCustomerAdapter: UpdateCustomerAdapter
    ): UpdateCustomerInputPort{
        return UpdateCustomer(
            findCustomerById,
            findAddressByIdAdapter,
            updateCustomerAdapter
        )
    }
}