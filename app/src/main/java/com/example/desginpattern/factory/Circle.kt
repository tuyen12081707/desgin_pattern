package com.example.desginpattern.factory

import android.util.Log

class Circle : IDraw {
    override fun draw() {
        Log.d("TAG===", "draw: by Circle")
    }
}