package com.example.myapplicationmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplicationmvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel;
     var binding:ActivityMainBinding?=null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        init();
    }
    private fun init()
    {
        var myDb = MyDb.getDb(applicationContext).getDao();
        val repository = MyRepository(myDb);
        mainViewModel = ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java);

        mainViewModel.getData().observe(this, Observer {

            for(i in it.indices)
            {
                binding!!.myData  = it.get(i).name + "\n";
            }


        })

        binding!!.btnAdd.setOnClickListener(object : View.OnClickListener
        {
            override fun onClick(p0: View?) {
                mainViewModel.insert(MyData(0,binding!!.edtName.text.toString(),"8327708358"));
            }

        })
    }
}