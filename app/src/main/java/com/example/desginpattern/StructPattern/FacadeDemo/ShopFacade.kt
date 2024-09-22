package com.example.desginpattern.StructPattern.FacadeDemo

class ShopFacade private constructor() {

    companion object {
        @Volatile
        private var instance: ShopFacade? = null

        fun getInstance(): ShopFacade =
            instance ?: synchronized(this) { // synchronized to avoid concurrency issues
                instance ?: ShopFacade().also { instance = it }
            }
    }

    private var accountService: AccountService = AccountService()
    private var shippingService: ShippingService = ShippingService()

    // Public method to perform a purchase
    fun buyProductByCashWithFreeShipping(email: String?) {
        email?.let {
            accountService.getAccount(it)
        }
        shippingService.freeShipping()
        println("Done\n")
    }
}
fun main(){
    val shope = ShopFacade.getInstance().buyProductByCashWithFreeShipping("tuyen@gmail.com")
}
