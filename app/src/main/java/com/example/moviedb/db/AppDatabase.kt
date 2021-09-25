package com.example.moviedb.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.moviedb.data.model.Popular
import com.example.moviedb.data.model.RepositoryData
import com.example.moviedb.model.RemoteKeys

@Database(entities = arrayOf(RepositoryData::class,RemoteKeys::class),version = 4,exportSchema = false)
abstract class AppDatabase : RoomDatabase()
    {
        abstract fun getMovieDao(): MovieDao

        abstract fun  getRemoteKeysDao(): RemoteKeysDao

        companion object
        {
            private var DB_INSTANCE : AppDatabase?=null
            fun getAppDBInstance(context:Context) :AppDatabase
            {
              if(DB_INSTANCE == null)
              {
                DB_INSTANCE =Room.databaseBuilder(context.applicationContext,AppDatabase::class.java,"APP_DB")
                    .allowMainThreadQueries()
                    .build()
              }
                return DB_INSTANCE!!
            }
        }
    }
