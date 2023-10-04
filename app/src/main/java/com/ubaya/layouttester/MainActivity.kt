package com.ubaya.layouttester

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ubaya.layouttester.databinding.ActivityMainBinding
import com.ubaya.layouttester.databinding.MovieItemBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        //setContentView(R.layout.activity_main)
        setContentView(view)

        val lm:LinearLayoutManager = LinearLayoutManager(this)
        val gm:GridLayoutManager = GridLayoutManager(this, 2)
        val sm:StaggeredGridLayoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.recycleView.layoutManager = lm
        binding.recycleView.setHasFixedSize(true)
        binding.recycleView.adapter = MovieAdapter()

    }
}