package com.example.desginpattern.StructPattern
import java.util.Base64


interface ChatService {
    fun sendMessage(message: String)
    fun getMessage(): String
}
class DefaultChatService : ChatService {
    override fun sendMessage(message: String) {
        // Send message
    }
    override fun getMessage(): String {
        return "message from me"
    }
}
class ChatServiceSecureProxy(private val encoder: Encoder) : ChatService {
    private val chatService: ChatService = DefaultChatService()
    override fun sendMessage(message: String) {
        chatService.sendMessage(encoder.encode(message))
    }
    override fun getMessage(): String {
        val message = chatService.getMessage()
        return encoder.decode(message)
    }
}
class Encoder {
    fun encode(input: String): String {
        return Base64.getEncoder().encodeToString(input.toByteArray())
    }
    fun decode(encoded: String): String {
      return  String(Base64.getDecoder().decode(encoded.trim()))
    }
}
class ProxyPattern (){
    fun main(){
        val encoder = Encoder()
        val chatService = ChatServiceSecureProxy(encoder)
        chatService.sendMessage("Hello")
        println("Received message: ${chatService.getMessage()}")
    }
}
