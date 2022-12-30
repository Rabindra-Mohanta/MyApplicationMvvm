package com.example.myapplicationmvvm

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [MyData::class], version = 1)
abstract class MyDb: RoomDatabase(){
    abstract fun getDao():MyDao;

    companion object
    {
        @Volatile
        private var INSTANCE:MyDb?=null;
        fun getDb(context: Context):MyDb
        {
            synchronized(this)
            {
                if(INSTANCE==null)
                {
                    INSTANCE = Room.databaseBuilder(context,MyDb::class.java,"MyDb").build();
                }
            }

            return INSTANCE!!;
        }
    }

}