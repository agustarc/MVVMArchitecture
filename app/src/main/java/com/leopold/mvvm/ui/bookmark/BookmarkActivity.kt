package com.leopold.mvvm.ui.bookmark

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.leopold.mvvm.R
import com.leopold.mvvm.databinding.ActivityBookmarkBinding
import org.koin.androidx.viewmodel.ext.android.getViewModel

/**
 * @author Leopold
 */
class BookmarkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityBookmarkBinding>(this, R.layout.activity_bookmark)
        binding.vm = getViewModel()
        binding.setLifecycleOwner(this)
    }
}