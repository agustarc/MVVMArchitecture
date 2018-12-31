package com.leopold.mvvm.viewmodel.bookmark

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.leopold.mvvm.data.db.dao.BookmarkDao
import com.leopold.mvvm.data.db.entity.Bookmark
import com.leopold.mvvm.util.ioThread

/**
 * @author Leopold
 */
class BookmarkViewModel(private val dao: BookmarkDao) : ViewModel() {
    val items: LiveData<PagedList<Bookmark>> = LivePagedListBuilder(dao.findAll(),  /* page size */ 10).build()

    fun delete(bookmark: Bookmark) = ioThread { dao.delete(bookmark) }
}