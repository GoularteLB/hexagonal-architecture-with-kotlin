package com.architecture.hexagonal.application.core.usecase

import com.architecture.hexagonal.adapters.out.SendCpfForValidationAdapter
import com.architecture.hexagonal.application.core.domain.Customer
import com.architecture.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import com.architecture.hexagonal.application.ports.`in`.UpdateCustomerInputPort
import com.architecture.hexagonal.application.ports.out.FindAddressByZipCodeOutPutPort
import com.architecture.hexagonal.application.ports.out.UpdateCustomerOutPutPort

class UpdateCustomer(
    private val findCustomerByIdInputPort: FindCustomerByIdInputPort,
    private val findAddressByZipCodeOutPutPort: FindAddressByZipCodeOutPutPort,
    private val updateCustomerOutPutPort: UpdateCustomerOutPutPort,
    private val sendCpfForValidationAdapter: SendCpfForValidationAdapter
): UpdateCustomerInputPort {

    override fun Update(customer: Customer, ZipCode: String) {
        if(customer.id ==null)throw IllegalArgumentException("The id not be null")
        val saveCpf = findCustomerByIdInputPort.find(customer.id).cpf

        customer.apply {
            address = findAddressByZipCodeOutPutPort.find(ZipCode)
        }.let {
            updateCustomerOutPutPort.update(it)
            if (saveCpf != it.cpf){
                sendCpfForValidationAdapter.send(it.cpf)
            }
        }
    }
}