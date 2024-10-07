package com.architecture.hexagonal.adapters.out

import com.architecture.hexagonal.application.ports.out.SendCpfForValidationOutPutPort
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class SendCpfForValidationAdapter(
    private val kafkaTemplate: KafkaTemplate<String, String>
): SendCpfForValidationOutPutPort {
    override fun send(cpf: String) {
        kafkaTemplate.send("tp-cpf-validation", cpf)
    }

}