package com.example.myapplicationmvvm

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MyData")
data  class MyData(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val name:String,
    val number:String

)