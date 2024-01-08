package com.example.android_mvc.MVVM.Repository

import com.example.android_mvc.MVVM.Model.Image
import io.reactivex.Single

interface ImageRepository {
    fun getRandomImage(): Single<Image>
}