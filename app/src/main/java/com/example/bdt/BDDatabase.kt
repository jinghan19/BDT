package com.example.bdt

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database (entities = [BD::class],version = 1 )
abstract class BDDatabase:RoomDatabase() {

    abstract fun bdDao():BDDao //function that return data access object

    companion object{
        @Volatile
        private var INSTANCE:BDDatabase?=null

        fun getInstance(context:Context):BDDatabase{
            synchronized(this){ //if open project dun hav database then at the same time create database
                var instance= INSTANCE
                if(instance == null){
                    instance= Room.databaseBuilder( context.applicationContext,BDDatabase::class.java,"birthday_database")
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE=instance
                }
                return instance
            }
        }
    }
}