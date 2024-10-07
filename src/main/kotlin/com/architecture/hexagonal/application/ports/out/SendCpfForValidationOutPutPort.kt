package com.architecture.hexagonal.application.ports.out

interface SendCpfForValidationOutPutPort {
    fun send(cpf: String)
}