package com.example.desginpattern.factory

import android.util.Log

class Square : IDraw {
    override fun draw() {
        Log.d("TAG===", "draw: by Square")
    }
}