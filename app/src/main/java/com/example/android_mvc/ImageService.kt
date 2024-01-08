package com.example.android_mvc

import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ImageService {
  @Headers(Key.key)
  @GET("photos/random")
  fun getRandomImage() : Call<ImageResponse>

  @Headers(Key.key)
  @GET("photos/random")
  fun getRandomImageRx()  : Single<ImageResponse>

}