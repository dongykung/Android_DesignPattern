package com.example.android_mvc.MVVM.Repository

import com.example.android_mvc.MVVM.Model.Image
import com.example.android_mvc.RetrofitManager
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers

import io.reactivex.schedulers.Schedulers

class ImageRepositoryImpl:ImageRepository  {
    override fun getRandomImage() = RetrofitManager.imageService.getRandomImageRx()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .flatMap {item->
            Single.just(Image(item.urls.regular,item.color))
        }
}

