package com.leopold.mvvm

import androidx.arch.core.executor.ArchTaskExecutor
import androidx.arch.core.executor.TaskExecutor
import com.leopold.mvvm.data.db.dao.BookmarkDao
import com.leopold.mvvm.viewmodel.search.SearchViewModel
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.notNullValue
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.StandAloneContext.stopKoin
import org.koin.standalone.get
import org.koin.test.KoinTest
import org.mockito.Mockito

/**
 * @author Leopold
 */
class SearchViewModelTest : KoinTest {
    private lateinit var viewModel: SearchViewModel

    @Before fun before() {
        startKoin(listOf(testApiModule))

        ArchTaskExecutor.getInstance().setDelegate(object : TaskExecutor() {
            override fun executeOnDiskIO(runnable: Runnable) = runnable.run()
            override fun isMainThread(): Boolean  = true
            override fun postToMainThread(runnable: Runnable) = runnable.run()
        })

        viewModel = SearchViewModel(get(), Mockito.mock(BookmarkDao::class.java))
    }

    @After fun after() {
        ArchTaskExecutor.getInstance().setDelegate(null)
        stopKoin()
    }

    @Test fun viewModelNotNull() {
        assertThat(viewModel, notNullValue())
    }
}