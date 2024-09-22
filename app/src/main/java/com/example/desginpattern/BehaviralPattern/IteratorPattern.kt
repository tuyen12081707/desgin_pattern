package com.example.desginpattern.BehaviralPattern

interface Iterator<T> {
    fun hasNext(): Boolean
    fun next(): T
}
interface Aggregate<T> {
    fun createIterator(): Iterator<T>
}
class ItemCollection : Aggregate<String> {
    private val items = mutableListOf<String>()

    fun addItem(item: String) {
        items.add(item)
    }

    override fun createIterator(): Iterator<String> {
        return ItemIterator(this)
    }

    fun getItem(index: Int): String {
        return items[index]
    }

    fun size(): Int {
        return items.size
    }
}
class ItemIterator(private val collection: ItemCollection) : Iterator<String> {
    private var index = 0

    override fun hasNext(): Boolean {
        return index < collection.size()
    }

    override fun next(): String {
        return collection.getItem(index++)
    }
}
fun main() {
    val collection = ItemCollection()
    collection.addItem("Item 1")
    collection.addItem("Item 2")
    collection.addItem("Item 3")

    val iterator = collection.createIterator()

    while (iterator.hasNext()) {
        val item = iterator.next()
        println(item)
    }
}
