package com.example.myapplicationmvvm

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface MyDao {
    @Insert
    suspend fun insertData(myData: MyData);
    @Update
    suspend fun updateData(myData: MyData);
    @Delete
    suspend fun deleteData(myData: MyData);

    @Query("SELECT * FROM MyData")
    fun getAllData():LiveData<List<MyData>>;
}