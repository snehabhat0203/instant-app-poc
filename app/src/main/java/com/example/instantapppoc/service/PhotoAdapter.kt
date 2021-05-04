package com.example.instantapppoc.service

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.instantapppoc.R
import kotlinx.android.synthetic.main.viewholder_photos.view.*

class PhotoAdapter(private var photos: List<Photo>, private val listener: ClickListener) :
    RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.viewholder_photos, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bindData(photo = photos[position])
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    fun setData(list: List<Photo>) {
        photos = list
    }

    inner class PhotoViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bindData(photo: Photo) {
            Glide.with(view.context)
                .load(photo.post_url)
                .override(480, 480)
                .into(view.image_view)
            view.image_view.setOnClickListener { listener.onClick(photo, adapterPosition) }
        }
    }
}