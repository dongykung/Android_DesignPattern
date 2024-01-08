package com.example.android_mvc.MVVM

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import coil.load
import com.example.android_mvc.MVVM.Repository.ImageRepositoryImpl
import com.example.android_mvc.R
import com.example.android_mvc.databinding.ActivityMvvmBinding

class MvvmActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMvvmBinding
    private val viewModel : MvvmViewModel by viewModels{
        MvvmViewModel.MvvmViewModelFactory(ImageRepositoryImpl())
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvvmBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.loadmvvmButton.setOnClickListener { loadImage() }
        viewModel.imageLiveData.observe(this){
            binding.mvvmImageView.load(it.url)
        }
        viewModel.countLiveData.observe(this){
            binding.imageCountTexetView.text=it
        }

    }
    private fun loadImage(){
        viewModel.loadRandomImage()
    }
}