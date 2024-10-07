package com.architecture.hexagonal.adapters.`in`.consumer

import com.architecture.hexagonal.adapters.`in`.consumer.message.CustomerMessage
import com.architecture.hexagonal.application.ports.`in`.UpdateCustomerInputPort
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class ReceiveValidatedCustomerDataConsumer(
    private val updateCustomerInputPort: UpdateCustomerInputPort
) {

    @KafkaListener(topics = ["tp-cpf-validated"], groupId = "customer-group")
    fun receive(customerMessage: CustomerMessage) {
        with(customerMessage){
            updateCustomerInputPort.Update(toCustomer(), zipCode)
        }

    }
}
