package com.example.android_mvc.MVP.repository

import com.example.android_mvc.ImageResponse
import com.example.android_mvc.RetrofitManager
import retrofit2.Call
import retrofit2.Response

class ImageRepositoryImpl :ImageRepository {
    override fun getRandomImage(callback: ImageRepository.Callback) {
        RetrofitManager.imageService.getRandomImage()
            .enqueue(object:retrofit2.Callback<ImageResponse>{
                override fun onResponse(
                    call: Call<ImageResponse>,
                    response: Response<ImageResponse>
                ) {
                    if(response.isSuccessful){
                        response.body()?.let {
                            callback.loadImage( it.urls.regular,it.color)
                        }
                    }
                }

                override fun onFailure(call: Call<ImageResponse>, t: Throwable) {

                }

            })
    }
}