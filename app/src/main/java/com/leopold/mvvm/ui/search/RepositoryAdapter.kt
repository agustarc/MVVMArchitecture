package com.leopold.mvvm.ui.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.leopold.mvvm.R
import com.leopold.mvvm.data.remote.domain.Repository
import com.leopold.mvvm.databinding.LayoutRepositoryItemBinding
import com.leopold.mvvm.ui.BindingViewHolder
import com.leopold.mvvm.viewmodel.search.SearchViewModel

/**
 * @author Leopold
 */
class RepositoryAdapter(var items: List<Repository> = arrayListOf()) : RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder>() {
    private var vm: SearchViewModel? = null

    fun setViewModel(vm: SearchViewModel) {
        this.vm = vm
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        return RepositoryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_repository_item, parent, false))
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.binding.item = items[position]
        holder.binding.vm = vm
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class RepositoryViewHolder(view: View) : BindingViewHolder<LayoutRepositoryItemBinding>(view)
}