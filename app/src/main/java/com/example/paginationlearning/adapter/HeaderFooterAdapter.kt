package com.example.paginationlearning.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.paginationlearning.R
import kotlinx.android.synthetic.main.progress_bar.view.*

class HeaderFooterAdapter : LoadStateAdapter<HeaderFooterAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.progress_bar, parent, false
        ))
    }

    override fun onBindViewHolder(holder: ViewHolder, loadState: LoadState) {
        if(loadState is LoadState.Loading) {
            holder.itemView.progressBar.visibility = View.VISIBLE
        } else {
            holder.itemView.progressBar.visibility = View.INVISIBLE
        }
    }
}