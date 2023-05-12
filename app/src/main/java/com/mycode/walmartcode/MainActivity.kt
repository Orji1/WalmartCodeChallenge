package com.mycode.walmartcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mycode.walmartcode.adapter.CountryListAdapter
import com.mycode.walmartcode.databinding.ActivityMainBinding
import com.mycode.walmartcode.repository.MainRepository
import com.mycode.walmartcode.service.RetrofitService
import com.mycode.walmartcode.viewmodel.MainViewModel
import com.mycode.walmartcode.viewmodel.MyViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    private val adapter2 = CountryListAdapter()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val retrofitService = RetrofitService.getInstance()
        val mainRepository = MainRepository(retrofitService)
        binding.countriesRecycler.apply {
            layoutManager = LinearLayoutManager(
               applicationContext,
                LinearLayoutManager.VERTICAL,
                false
            )
            adapter = adapter2
        }
        viewModel = ViewModelProvider(this, MyViewModelFactory(mainRepository)).get(MainViewModel::class.java)

        viewModel.countriesist.observe(this) {
            adapter2.setCountries(it)
        }

        viewModel.errorMessage.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
        viewModel.loading.observe(this, Observer {
            if (it) {
               binding.countryProgress.visibility = View.VISIBLE
            } else {
                binding.countryProgress.visibility = View.GONE

            }
        })
        viewModel.getAllMovies()
    }
}