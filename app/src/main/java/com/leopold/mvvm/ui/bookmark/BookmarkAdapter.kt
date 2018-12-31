package com.leopold.mvvm.ui.bookmark

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.leopold.mvvm.R
import com.leopold.mvvm.data.db.entity.Bookmark
import com.leopold.mvvm.databinding.LayoutBookmarkItemBinding
import com.leopold.mvvm.viewmodel.bookmark.BookmarkViewModel

/**
 * @author Leopold
 */
class BookmarkAdapter : PagedListAdapter<Bookmark, BookmarkAdapter.BookmarkViewHolder>(DIFF_CALLBACK) {
    private var vm: BookmarkViewModel? = null

    fun setViewModel(vm: BookmarkViewModel) {
        this.vm = vm
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkViewHolder {
        return BookmarkViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_bookmark_item, parent, false))
    }

    override fun onBindViewHolder(holder: BookmarkViewHolder, position: Int) {
        getItem(position)?.run {
            holder.binding.item = this
            holder.binding.vm = vm
        }
    }

    class BookmarkViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: LayoutBookmarkItemBinding = LayoutBookmarkItemBinding.bind(view)
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Bookmark>() {
            override fun areItemsTheSame(oldItem: Bookmark, newItem: Bookmark): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Bookmark, newItem: Bookmark): Boolean {
                return oldItem == newItem
            }
        }
    }
}