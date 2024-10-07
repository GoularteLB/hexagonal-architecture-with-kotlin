package com.architecture.hexagonal.infrastructure

import com.architecture.hexagonal.adapters.`in`.consumer.message.CustomerMessage
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.serializer.JsonDeserializer

@EnableKafka
@Configuration
class kafkaConsumerConfig {

    private val configProps = mapOf(
        ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG to "localhost:9092",
        ConsumerConfig.GROUP_ID_CONFIG to "localhost",
        ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java,
        ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java,
        ConsumerConfig.AUTO_OFFSET_RESET_CONFIG to "earliest"
    )

    @Bean
    fun consumerFactory(): ConsumerFactory<String, CustomerMessage> =
        DefaultKafkaConsumerFactory(configProps, StringDeserializer(), JsonDeserializer(CustomerMessage::class.java))


    @Bean
    fun kafkaListenerConteinerFactory(): ConcurrentKafkaListenerContainerFactory<String, CustomerMessage> =
        ConcurrentKafkaListenerContainerFactory<String, CustomerMessage>().apply {
            consumerFactory = consumerFactory()
        }
}