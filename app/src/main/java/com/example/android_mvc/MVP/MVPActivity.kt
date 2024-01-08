package com.example.android_mvc.MVP

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.example.android_mvc.MVP.Model.ImageCountModel
import com.example.android_mvc.MVP.repository.ImageRepository
import com.example.android_mvc.MVP.repository.ImageRepositoryImpl
import com.example.android_mvc.R
import com.example.android_mvc.databinding.ActivityMvpactivityBinding

class MVPActivity : AppCompatActivity(),MvpConracter.View {
    private lateinit var binding:ActivityMvpactivityBinding
    private lateinit var presenter: MvpConracter.Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvpactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = MvpPresenter(ImageCountModel(),ImageRepositoryImpl())
        presenter.attachView(this)
        binding.loadmvpButton.setOnClickListener { loadImage() }
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }
    private fun loadImage(){
        presenter.loadRandomImage()
    }

    override fun showImage(url: String, color: String) {
       binding.mvpImageView.apply {
           setBackgroundColor(Color.parseColor(color))
           load(url){
               crossfade(300)
           }
       }
    }

    override fun showImageCountText(count: Int) {
       binding.imageCountTexetView.text="불러온 이미지 수 :$count"
    }
}