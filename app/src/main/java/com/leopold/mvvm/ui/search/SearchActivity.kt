package com.leopold.mvvm.ui.search

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.LayoutRes
import com.leopold.mvvm.R
import com.leopold.mvvm.databinding.ActivitySearchBinding
import com.leopold.mvvm.ui.BindingActivity
import com.leopold.mvvm.ui.bookmark.BookmarkActivity
import org.koin.androidx.viewmodel.ext.android.getViewModel

/**
 * @author Leopold
 */
class SearchActivity : BindingActivity<ActivitySearchBinding>() {
    @LayoutRes
    override fun getLayoutResId() = R.layout.activity_search

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.vm = getViewModel()
        binding.setLifecycleOwner(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.bookmark -> {
                startActivity(Intent(this, BookmarkActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}