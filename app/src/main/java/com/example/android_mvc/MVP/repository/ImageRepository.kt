package com.example.android_mvc.MVP.repository

interface ImageRepository {
    fun getRandomImage(callback:Callback)

    interface Callback{
        fun loadImage(url:String,color:String)
    }

}