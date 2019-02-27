package com.leopold.mvvm.ui.bookmark

import android.os.Bundle
import androidx.annotation.LayoutRes
import com.leopold.mvvm.R
import com.leopold.mvvm.databinding.ActivityBookmarkBinding
import com.leopold.mvvm.ui.BindingActivity
import org.koin.androidx.viewmodel.ext.android.getViewModel

/**
 * @author Leopold
 */
class BookmarkActivity : BindingActivity<ActivityBookmarkBinding>() {
    @LayoutRes
    override fun getLayoutResId() = R.layout.activity_bookmark

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.vm = getViewModel()
        binding.setLifecycleOwner(this)
    }
}