package com.example.desginpattern.BehaviralPattern

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class Product(val name: String)

data class State(val products: List<Product> = emptyList())
class Store {
    private val mutableState = MutableStateFlow(State())
    val state = mutableState.asStateFlow()

    fun addProduct(product: Product) {
        mutableState.update { state ->
            state.copy(products = state.products + product)
        }
    }

    fun removeProduct(product: Product) {
        mutableState.update { state ->
            state.copy(products = state.products - product)
        }
    }
}
class Client(
    private val store: Store,
) {
    private val scope = CoroutineScope(SupervisorJob())
    private var job: Job? = null

    fun getNotified() {
        if (job != null) return
        scope.launch {
            job = store.state.onEach { state ->
                println(state.products.toString())
            }.launchIn(this)
        }
    }

    fun removeNotification() {
        job?.cancel()
        job = null
    }
}
fun main() {
    val store = Store()
    val client1 = Client(store)
    val client2 = Client(store)

    val apple = Product("Apple")
    store.addProduct(apple)

    // Produced, because StateFlow emits last value when we start observing
    client1.getNotified() // [Product(name=Apple)]
    client2.getNotified() // [Product(name=Apple)]

    store.removeProduct(apple) // It prints twice because we have 2 collectors
    // []
    // []

    client1.removeNotification()

    val banana = Product("banana")
    store.addProduct(banana)  // Now we only have 1 collector
    // [Product(name=banana)]
}