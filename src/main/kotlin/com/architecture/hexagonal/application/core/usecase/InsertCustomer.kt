package com.architecture.hexagonal.application.core.usecase

import com.architecture.hexagonal.application.core.domain.Customer
import com.architecture.hexagonal.application.ports.`in`.InsertCustomerInputPort
import com.architecture.hexagonal.application.ports.out.FindAddressByZipCodeOutPutPort
import com.architecture.hexagonal.application.ports.out.InsertCustomerOutputPort
import com.architecture.hexagonal.application.ports.out.SendCpfForValidationOutPutPort


class InsertCustomer(
    private val findAddressByZipCodeOutPutPort : FindAddressByZipCodeOutPutPort,
    private val isertCustomerOutputPort : InsertCustomerOutputPort,
    private val sendCpfForValidationOutPutPort: SendCpfForValidationOutPutPort
): InsertCustomerInputPort {
    override fun insert(customer:Customer, zipCoder: String){
        customer.apply{
            address = findAddressByZipCodeOutPutPort.find(zipCoder)
        }.let {
            isertCustomerOutputPort.insert(it)
            sendCpfForValidationOutPutPort.send(it.cpf)
        }
    }
}