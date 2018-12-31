package com.leopold.mvvm.data.db.dao

import androidx.paging.DataSource
import androidx.room.*
import com.leopold.mvvm.data.db.entity.Bookmark

/**
 * @author Leopold
 */
@Dao
interface BookmarkDao {

    @Query("SELECT * FROM Bookmark ORDER BY created ASC")
    fun findAll(): DataSource.Factory<Int, Bookmark>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(bookmark: Bookmark)

    @Delete
    fun delete(bookmark: Bookmark)

}