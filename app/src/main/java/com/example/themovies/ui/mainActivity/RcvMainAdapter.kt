package com.example.themovies.ui.mainActivity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.themovies.R
import com.example.themovies.databinding.RcvMainBinding
import com.example.themovies.models.TranslateModel

class RcvMainAdapter(
    private val models: List<TranslateModel>?
) : RecyclerView.Adapter<RcvMainAdapter.RcvMainViewHolder>() {

    inner class RcvMainViewHolder(
        val rcvMainBinding: RcvMainBinding
    ) : RecyclerView.ViewHolder(rcvMainBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RcvMainViewHolder =
        RcvMainViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.rcv_main,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: RcvMainViewHolder, position: Int) {
        models?.get(position)?.let {
            holder.rcvMainBinding.model = it
        }
    }

    override fun getItemCount() = models?.size ?: 0

}