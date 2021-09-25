package com.example.moviedb.di

import android.app.Application
import android.content.Context
import com.example.moviedb.db.AppDatabase
import com.example.moviedb.db.MovieDao
import com.example.moviedb.db.RemoteKeysDao
import com.example.moviedb.netwoek.RetroServiceInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun getAppDatabase(context: Application): AppDatabase
    {
        return AppDatabase.getAppDBInstance(context)
    }
    @Provides
    @Singleton
   fun getMovieDao(appDatabase: AppDatabase): MovieDao
   {
       return appDatabase.getMovieDao()
   }

    @Provides
    @Singleton
    fun getRemoteKeysDao(appDatabase: AppDatabase): RemoteKeysDao
    {
        return appDatabase.getRemoteKeysDao()
    }
   val BASE_URL ="https://api.themoviedb.org/3/"
    @Provides
    @Singleton
    fun getRetroServiceInstance(retrofit: Retrofit):RetroServiceInterface{
      return  retrofit.create(RetroServiceInterface::class.java)
     }
    @Provides
    @Singleton
    fun RetroInstance():Retrofit
    {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}