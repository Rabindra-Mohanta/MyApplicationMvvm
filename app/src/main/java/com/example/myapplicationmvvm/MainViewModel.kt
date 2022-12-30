package com.example.myapplicationmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(var myRepository: MyRepository):ViewModel() {

    fun insert(myData: MyData)
    {
        viewModelScope.launch(Dispatchers.IO)
        {
            myRepository.insert(myData);
        }
    }

    fun delete(myData: MyData)
    {
        viewModelScope.launch(Dispatchers.IO)
        {
            myRepository.delete(myData);
        }
    }

    fun update(myData: MyData)
    {
        viewModelScope.launch(Dispatchers.IO)
        {
            myRepository.update(myData);
        }
    }
    fun getData():LiveData<List<MyData>>
    {
        return myRepository.getData();
    }
}