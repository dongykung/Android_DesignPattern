 package com.example.android_mvc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_mvc.MVC.MVCActivity
import com.example.android_mvc.MVP.MVPActivity
import com.example.android_mvc.databinding.ActivityMainBinding

 class MainActivity : AppCompatActivity() {
    private lateinit var binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.MVCButton.setOnClickListener { openMVC() }
        binding.MVPBUtton.setOnClickListener { openMVP() }
        binding.MVVMButton.setOnClickListener { openMVVM() }
        binding.MVIButton.setOnClickListener { openMVI() }
    }

      fun openMVC(){
        val intent = Intent(this,MVCActivity::class.java)
        startActivity(intent)
     }
      fun openMVP(){
          val intent = Intent(this,MVPActivity::class.java)
          startActivity(intent)
     }
      fun openMVVM(){

     }
      fun openMVI(){

     }
}