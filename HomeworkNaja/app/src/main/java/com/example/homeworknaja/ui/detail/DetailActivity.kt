package com.example.homeworknaja.ui.detail

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.homeworknaja.R
import com.example.homeworknaja.databinding.ActivityDetailBinding
import com.example.homeworknaja.databinding.ActivityMainBinding
import com.example.homeworknaja.model.SimpleModel

class DetailActivity : AppCompatActivity() {
    private val detailviewBinding: ActivityDetailBinding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(detailviewBinding.root)
        val itemview=intent?.getSerializableExtra("itemView") as SimpleModel

        detailviewBinding.titel.setText(itemview.title)
        detailviewBinding.detail.setText(itemview.subtitle)
      //  detailviewBinding.videoView.setVideoPath(itemview.youtubeUrl)
      //  detailviewBinding.imageView.setImageURI(itemview.youtubeImage)
        Glide.with(this).load(itemview.youtubeImage).into(detailviewBinding.imageView);


    }
}