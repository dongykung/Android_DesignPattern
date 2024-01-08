package com.example.android_mvc.MVC

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.example.android_mvc.MVC.Provider.ImageProvider
import com.example.android_mvc.R
import com.example.android_mvc.databinding.ActivityMvcactivityBinding

class MVCActivity : AppCompatActivity(),ImageProvider.Callback {
    private lateinit var binding : ActivityMvcactivityBinding
    private var model = ImageCountModel()
    private var imageProvider = ImageProvider(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvcactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loadmvcButton.setOnClickListener {loadImage()}
    }

    private fun loadImage(){
        imageProvider.getRandomImage()
    }

    override fun loadImage(url: String, color: String) {
        model.increase()
        binding.mvcImageView.apply {
            setBackgroundColor(Color.parseColor(color))
            load(url)
        }
        binding.imageCountTexetView.text="불러온 이미지 수 ${model.count}"
    }
}