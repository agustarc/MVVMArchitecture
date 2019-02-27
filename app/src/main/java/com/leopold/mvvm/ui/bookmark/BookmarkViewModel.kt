package com.leopold.mvvm.ui.bookmark

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.leopold.mvvm.core.BaseViewModel
import com.leopold.mvvm.data.db.dao.BookmarkDao
import com.leopold.mvvm.data.db.entity.Bookmark
import com.leopold.mvvm.util.ioThread

/**
 * @author Leopold
 */
class BookmarkViewModel(private val dao: BookmarkDao) : BaseViewModel() {
    val items: LiveData<PagedList<Bookmark>> = LivePagedListBuilder(dao.findAll(),  /* page size */ 10).build()

    fun delete(bookmark: Bookmark) = ioThread { dao.delete(bookmark) }
}