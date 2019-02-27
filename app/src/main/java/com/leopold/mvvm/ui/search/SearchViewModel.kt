package com.leopold.mvvm.ui.search

import com.leopold.mvvm.core.BaseViewModel
import com.leopold.mvvm.data.db.dao.BookmarkDao
import com.leopold.mvvm.data.db.entity.Bookmark
import com.leopold.mvvm.data.remote.api.SearchAPI
import com.leopold.mvvm.data.remote.domain.Repository
import com.leopold.mvvm.util.NotNullMutableLiveData
import com.leopold.mvvm.util.ioThread
import com.leopold.mvvm.extension.with

/**
 * @author Leopold
 */
class SearchViewModel(private val api: SearchAPI, private val dao: BookmarkDao) : BaseViewModel() {
    private var query: String = ""
        get() = if (field.isEmpty()) "MVVM" else field

    private val _refreshing: NotNullMutableLiveData<Boolean> = NotNullMutableLiveData(false)
    val refreshing: NotNullMutableLiveData<Boolean>
        get() = _refreshing

    private val _items: NotNullMutableLiveData<List<Repository>> = NotNullMutableLiveData(arrayListOf())
    val items: NotNullMutableLiveData<List<Repository>>
        get() = _items

    fun doSearch() {
        val params = mutableMapOf<String, String>().apply {
            this["q"] = query
            this["sort"] = "stars"
        }

        addToDisposable(api.search(params).with()
            .doOnSubscribe { _refreshing.value = true }
            .doOnSuccess { _refreshing.value = false }
            .doOnError { _refreshing.value = false }
            .subscribe({
                _items.value = it.repositories
            }, {
                // handle errors
            }))
    }

    fun onQueryChange(query: CharSequence) {
        this.query = query.toString()
    }

    fun saveToBookmark(repository: Repository) = ioThread { dao.insert(Bookmark.to(repository)) }
}