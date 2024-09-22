package com.example.desginpattern.StructPattern.FacadeDemo

class ShippingService {
    fun freeShipping() {
        println("Free Shipping")
    }

    fun standardShipping() {
        println("Standard Shipping")
    }

    fun expressShipping() {
        println("Express Shipping")
    }
}