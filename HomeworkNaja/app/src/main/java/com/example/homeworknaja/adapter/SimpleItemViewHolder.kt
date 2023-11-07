package com.example.homeworknaja.adapter

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homeworknaja.databinding.ItemMainViewBinding
import com.example.homeworknaja.model.SimpleModel

class SimpleItemViewHolder(private val context: Context, itemView: View):
    RecyclerView.ViewHolder(itemView) {


    private val itemBinding get() = ItemMainViewBinding.bind(itemView)
    fun initView(simpleModel: SimpleModel, position: Int) {
        itemBinding.itemMainTitleTextLabel.text = simpleModel.title
        itemBinding.itemMainSubtitleTextLabel.text = simpleModel.subtitle
        Glide.with(context).load(simpleModel.youtubeImage).into(itemBinding.itemMainImageView)
    }

}