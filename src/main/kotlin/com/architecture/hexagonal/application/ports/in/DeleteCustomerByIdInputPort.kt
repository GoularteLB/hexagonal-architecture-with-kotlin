package com.architecture.hexagonal.application.ports.`in`

interface DeleteCustomerByIdInputPort {
    fun delete(id: String)
}