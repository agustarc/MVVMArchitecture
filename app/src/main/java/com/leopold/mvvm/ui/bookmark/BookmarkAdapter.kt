package com.leopold.mvvm.ui.bookmark

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.leopold.mvvm.R
import com.leopold.mvvm.data.db.entity.Bookmark
import com.leopold.mvvm.databinding.ItemBookmarkBinding
import com.leopold.mvvm.ui.BindingViewHolder

/**
 * @author Leopold
 */
class BookmarkAdapter(val vm: BookmarkViewModel) :
    PagedListAdapter<Bookmark, BookmarkAdapter.BookmarkViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkViewHolder {
        return BookmarkViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_bookmark,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BookmarkViewHolder, position: Int) {
        getItem(position)?.run {
            holder.binding.item = this
            holder.binding.vm = vm
        }
    }

    class BookmarkViewHolder(view: View) : BindingViewHolder<ItemBookmarkBinding>(view)

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Bookmark>() {
            override fun areItemsTheSame(oldItem: Bookmark, newItem: Bookmark) = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: Bookmark, newItem: Bookmark) = oldItem == newItem
        }
    }
}