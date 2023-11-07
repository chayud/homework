package com.example.homeworknaja.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.ListAdapter
import com.example.homeworknaja.R
import com.example.homeworknaja.databinding.ActivityDetailBinding
import com.example.homeworknaja.model.SimpleModel
import com.example.homeworknaja.ui.detail.DetailActivity

class SimpleItemAdapter(private val context: Context):
    ListAdapter<SimpleModel, SimpleItemViewHolder>(SimpleDiffUtil()) {

    var itemonclick: ((SimpleModel)->Unit)?=null

    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleItemViewHolder {
        val view = layoutInflater.inflate(R.layout.item_main_view, parent, false)
        return SimpleItemViewHolder(context, view)
    }

    override fun onBindViewHolder(holder: SimpleItemViewHolder, position: Int) {
        val simple = getItem(position)
        holder.initView(simple, position)
        holder.itemView.setOnClickListener{
            itemonclick?.invoke(simple);
//            val intent = Intent(context, DetailActivity::class.java)
//            intent.putExtra("itemView",simple)
//           // intent.putExtra("test",simple.id)
//            context.startActivity(intent)
//            val text = "Hello toast!"+simple.id
//            val duration = Toast.LENGTH_SHORT
//
//            val toast = Toast.makeText(context, text, duration).show() // in Activity


        }


        }

    }
