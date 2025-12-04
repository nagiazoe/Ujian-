package com.example.apkdata.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.apkdata.data.dao.UserDao
import com.example.apkdata.data.entity.User
import com.example.apkdata.data.entity.User2

@Database(entities =  [User::class, User2::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        private var  instance: AppDatabase? = null

        fun getinstance(context: Context): AppDatabase{
            if (instance == null){
                instance = Room.databaseBuilder(context, AppDatabase::class.java, "app-database")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }

            return instance!!
        }

    }
}