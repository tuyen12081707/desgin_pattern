package com.example.desginpattern

class Singleton {
    companion object {
        @Volatile private var instance: Singleton? = null
        fun getInstance() =
            instance ?: synchronized(this) { // synchronized to avoid concurrency problem
                if (instance == null) {
                    instance = Singleton()
                }
                instance ?: Singleton().also { instance = it}
            }
    }

}