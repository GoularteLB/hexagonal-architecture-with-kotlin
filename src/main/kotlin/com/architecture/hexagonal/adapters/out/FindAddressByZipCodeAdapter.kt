package com.architecture.hexagonal.adapters.out

import com.architecture.hexagonal.adapters.out.client.FindAddressByZipCodeClient
import com.architecture.hexagonal.adapters.out.client.response.AddressResponse
import com.architecture.hexagonal.application.core.domain.Address
import com.architecture.hexagonal.application.ports.out.FindAddressByZipCodeOutPutPort
import org.springframework.stereotype.Component

@Component
class FindAddressByZipCodeAdapter(
    private val findAddressByZipCodeClient: FindAddressByZipCodeClient
) : FindAddressByZipCodeOutPutPort {
    override fun find(zipCode: String):
            Address = findAddressByZipCodeClient.find(zipCode).toAddress()

}