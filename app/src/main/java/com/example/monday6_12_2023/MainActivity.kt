package com.example.monday6_12_2023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.monday6_12_2023.databinding.ActivityMainBinding
import com.example.monday6_12_2023.mainScreen.ui.DogViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val dogViewModel: DogViewModel by viewModels()

    private lateinit var mBiding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBiding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBiding.root)

        dogViewModel.getDog()

        dogViewModel.dog.observe(this, Observer {
            Glide.with(this)
                .load(it.message)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(mBiding.imgPhoto)
            mBiding.pbLoading.isVisible = false
        })

        mBiding.btnRefresh.setOnClickListener {
            mBiding.pbLoading.isVisible = true
            dogViewModel.getDog()
            mBiding.pbLoading.isVisible = false
        }
    }
}