package com.example.desginpattern.BehaviralPattern


class ObserverPatternJava {
}

// Định nghĩa Observer interface
internal interface Observer {
    fun update(message: String?)
}

// Định nghĩa Subject interface
internal interface Subject {
    fun attach(observer: Observer?)
    fun detach(observer: Observer?)
    fun notifyObservers()
}

// Lớp Subject cụ thể
internal class NewsAgency : Subject {
    private val observers: MutableList<Observer?> = ArrayList()
    private var news: String? = null

    fun setNews(news: String?) {
        this.news = news
        notifyObservers()
    }

    override fun attach(observer: Observer?) {
        observers.add(observer)
    }

    override fun detach(observer: Observer?) {
        observers.remove(observer)
    }

    override fun notifyObservers() {
        for (observer in observers) {
            observer?.update(news)
        }
    }
}

// Lớp Observer cụ thể
internal class NewsChannel : Observer {
    private var news: String? = null

    override fun update(news: String?) {
        this.news = news
        println("NewsChannel received news: $news")
    }
}

// Sử dụng Observer Pattern
object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val agency = NewsAgency()
        val channel1 = NewsChannel()
        val channel2 = NewsChannel()

        // Đăng ký các observer
        agency.attach(channel1)
        agency.attach(channel2)

        // Cập nhật tin tức
        agency.setNews("Breaking News!")

        // Hủy đăng ký một observer
        agency.detach(channel1)

        // Cập nhật tin tức mới
        agency.setNews("Latest Headlines!")
    }
}
