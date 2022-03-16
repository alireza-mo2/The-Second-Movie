package com.example.themovies.ui.mainActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.themovies.R
import com.example.themovies.databinding.ActivityMainBinding
import com.example.themovies.utils.DataState
import com.example.themovies.utils.hide
import com.example.themovies.utils.show
import com.example.themovies.utils.toast
import com.example.themovies.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        getData()
    }

    private fun getData() {
        viewModel.getTranslateList()
        viewModel.translateList.observe(this, Observer { dataState ->
            binding.dataState = dataState
            when (dataState) {
                is DataState.Loading -> {
                    //--
                }
                is DataState.Success -> {
                    binding.rcv1.apply {
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        adapter = RcvMainAdapter(dataState.data)
                    }
                }
                is DataState.Error -> {
                    toast(dataState.exception)
                }
            }
        })

    }
}