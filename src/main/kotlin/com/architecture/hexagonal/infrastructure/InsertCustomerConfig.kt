package com.architecture.hexagonal.infrastructure

import com.architecture.hexagonal.adapters.out.FindAddressByZipCodeAdapter
import com.architecture.hexagonal.adapters.out.InsertCustomerAdapter
import com.architecture.hexagonal.application.ports.`in`.InsertCustomerInputPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class InsertCustomerConfig {
    @Bean
    fun insertCustomer(
       findAddressByZipCodeAdapter: FindAddressByZipCodeAdapter,
       insertCustomerAdapter: InsertCustomerAdapter
    ) : InsertCustomerInputPort{
        return insertCustomer(findAddressByZipCodeAdapter, insertCustomerAdapter)
    }
}