package com.yatochk.travelclock2.dagger.module

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.yatochk.travelclock2.model.TravelDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule(private val app: Application) {

    @Provides
    fun provideContext(): Context {
        return app
    }

    @Singleton
    @Provides
    fun provideMedicationDatabase(context: Context): TravelDatabase =
        Room.databaseBuilder(
            context,
            TravelDatabase::class.java,
            TravelDatabase.DATABASE_NAME
        ).fallbackToDestructiveMigration()
            .build()

}