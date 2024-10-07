package com.architecture.hexagonal.infrastructure

import com.architecture.hexagonal.adapters.out.FindCustomerByIdAdapter
import com.architecture.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FindCustomerByIdConfig {
    @Bean
    fun findCustomerById(
        findCustomerByIdAdapter: FindCustomerByIdAdapter
    ): FindCustomerByIdInputPort{
        return findCustomerById(findCustomerByIdAdapter)
    }
}