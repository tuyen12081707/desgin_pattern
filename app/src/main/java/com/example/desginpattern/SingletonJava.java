package com.example.desginpattern;

public class SingletonJava { // Thread safe and lazy.

    private static volatile SingletonJava sInstance; // Volatile is necessary để đồng bộ trên tất cả các thread

    private SingletonJava() {}

    public static SingletonJava getInstance() {
        if (sInstance == null) {
            synchronized (Singleton.class) { // synchronized to avoid concurrency problem
                if (sInstance == null) {
                    sInstance = new SingletonJava();
                }
            }
        }
        return sInstance;
    }
    private void runUI(){

    }

}