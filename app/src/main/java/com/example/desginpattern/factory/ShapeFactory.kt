package com.example.desginpattern.factory

object ShapeFactory {
    fun drawShape(type: ShapeType): IDraw = when (type) {
        ShapeType.CIRCLE -> Circle()
        ShapeType.SQUARE -> Square()
        ShapeType.RETANGLE -> Retangle()
    }
}

sealed class ShapeType {
    object SQUARE : ShapeType()
    object CIRCLE : ShapeType()
    object RETANGLE : ShapeType()
}

