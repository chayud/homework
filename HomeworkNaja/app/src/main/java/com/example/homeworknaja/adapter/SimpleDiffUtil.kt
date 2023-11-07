package com.example.homeworknaja.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.homeworknaja.model.SimpleModel

class SimpleDiffUtil : DiffUtil.ItemCallback<SimpleModel>() {

    override fun areItemsTheSame(oldItem: SimpleModel, newItem: SimpleModel): Boolean = oldItem == newItem

    override fun areContentsTheSame(oldItem: SimpleModel, newItem: SimpleModel): Boolean = oldItem.id == newItem.id
}