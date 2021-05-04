package com.example.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.instantapppoc.service.ClickListener
import com.example.instantapppoc.service.Photo
import com.example.instantapppoc.service.PhotoAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ClickListener {
    private lateinit var photoAdapter: PhotoAdapter
    private val viewModel = MainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setRecyclerViewAdapter()
        viewModel._liveData.observe(this, Observer {
            photoAdapter.setData(it)
            photoAdapter.notifyDataSetChanged()
        })
        viewModel.getPhotos()
    }

    private fun setRecyclerViewAdapter() {
        photoAdapter = PhotoAdapter(emptyList(),this)
        image_recycler_view.apply {
            adapter = photoAdapter
            layoutManager = GridLayoutManager(this@MainActivity, 2)
        }
    }

    override fun onClick(item: Photo, position: Int) {
        val intent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://instantapppoc.com/details")
        )
        intent.setPackage(packageName)
        intent.addCategory(Intent.CATEGORY_BROWSABLE)
        startActivity(intent)
    }
}