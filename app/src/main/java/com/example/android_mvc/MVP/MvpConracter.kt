package com.example.android_mvc.MVP

interface MvpConracter {

    interface View{
        fun showImage(url:String,color:String)
        fun showImageCountText(count:Int)
    }
    interface Presenter{
        fun attachView(view:View)
        fun detachView()

        fun loadRandomImage()
    }
}