package com.example.desginpattern.StructPattern

import android.graphics.ImageFormat


class FacadePattern {

}

class ByteReader {
    fun read(fileName: String): ByteArray {
        return ByteArray(0)
    }

    fun getExtension(fileName: String): String {
        return ""
    }
}

class PngCompressor {
    fun compress(bytes: ByteArray): ByteArray {
        return ByteArray(0)
    }
}

class SvgCompressor {
    fun compress(bytes: ByteArray): ByteArray {
        return ByteArray(0)
    }
}

class JpgCompressor {
    fun compress(bytes: ByteArray): ByteArray {
        return ByteArray(0)
    }
}

class ImageCompressor {
    fun convert(fileName: String, targetFormat: ImageFormat): ByteArray {
        val byteRead = ByteReader()
        val bytes = byteRead.read(fileName)
        val extension = byteRead.getExtension(fileName)
        return when (extension) {
            "png" -> PngCompressor().compress(bytes)
            "svg" -> SvgCompressor().compress(bytes)
            "jpg" -> JpgCompressor().compress(bytes)
            else -> throw IllegalArgumentException("file format not supported")
        }
    }
}

fun main() {
    val imageCompressor = ImageCompressor()
    imageCompressor.convert("tuyenvui3",ImageFormat())
}