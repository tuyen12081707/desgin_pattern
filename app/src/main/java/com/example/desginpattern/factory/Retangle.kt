package com.example.desginpattern.factory

import android.util.Log

class Retangle : IDraw{
    override fun draw() {
        Log.d("TAG===", "draw: by Retangle")
    }

}
