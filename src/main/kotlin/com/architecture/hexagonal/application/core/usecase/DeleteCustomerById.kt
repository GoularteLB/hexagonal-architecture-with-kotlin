package com.architecture.hexagonal.application.core.usecase

import com.architecture.hexagonal.application.ports.`in`.DeleteCustomerByIdInputPort
import com.architecture.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import com.architecture.hexagonal.application.ports.out.DeleteCustomerByIdOutPutPort

class DeleteCustomerById(
    private val findCustomerByIdInputPort: FindCustomerByIdInputPort,
    private val deleteCustomerOutPutPort: DeleteCustomerByIdOutPutPort
): DeleteCustomerByIdInputPort {
    override fun delete(id: String){
        findCustomerByIdInputPort.find(id)
        deleteCustomerOutPutPort.delete(id)
    }
}