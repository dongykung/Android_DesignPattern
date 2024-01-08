package com.example.android_mvc.MVP

import com.example.android_mvc.MVP.Model.ImageCountModel
import com.example.android_mvc.MVP.repository.ImageRepository

class MvpPresenter(private val model:ImageCountModel,private val imageRepository: ImageRepository):MvpConracter.Presenter,
ImageRepository.Callback{

    private var view : MvpConracter.View?=null


    override fun attachView(view: MvpConracter.View) {
        this.view=view
    }

    override fun detachView() {
        view=null
    }

    override fun loadRandomImage() {
       imageRepository.getRandomImage(this)
    }

    override fun loadImage(url: String, color: String) {
        model.increase()
        view?.showImage(url,color)
        view?.showImageCountText(model.count)
    }
}