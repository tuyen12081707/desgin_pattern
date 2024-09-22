package com.example.desginpattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desginpattern.factory.ShapeFactory
import com.example.desginpattern.factory.ShapeType

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        val circle = ShapeFactory.drawShape(ShapeType.CIRCLE)
    }
}