package com.architecture.hexagonal.application.ports.out

interface DeleteCustomerByIdOutPutPort {
    fun delete(id: String)
}