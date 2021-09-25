package com.example.moviedb.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moviedb.data.model.Popular
import com.example.moviedb.model.RemoteKeys

@Dao
interface RemoteKeysDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertKey(remotekey:RemoteKeys)

    @Query("SELECT * FROM remotekey")
    fun remoteKeysUsingId(): RemoteKeys?

    @Query("DELETE FROM remotekey")
    fun removeAllKeys()
}