package com.example.myapplicationmvvm

import androidx.lifecycle.LiveData

class MyRepository(val dao: MyDao) {
    suspend fun insert(myData: MyData)
    {
        dao.insertData(myData);
    }
    suspend fun update(myData: MyData)
    {
        dao.updateData(myData);
    }
    suspend fun delete(myData: MyData)
    {
        dao.deleteData(myData);

    }

    fun getData():LiveData<List<MyData>>
    {
        return dao.getAllData();
    }
}