package com.architecture.hexagonal.application.ports.out

import com.architecture.hexagonal.application.core.domain.Address


interface FindAddressByZipCodeOutPutPort {
    fun find(ZipCode: String): Address
}