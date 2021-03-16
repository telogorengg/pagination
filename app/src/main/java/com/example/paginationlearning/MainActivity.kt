package com.example.paginationlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.paginationlearning.adapter.HeaderFooterAdapter
import com.example.paginationlearning.adapter.MainListAdapter
import com.example.paginationlearning.data.api.RetrofitBuilder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    private lateinit var mainListAdapter: MainListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewModel()
        setupList()
        setupView()
    }

    private fun setupViewModel() {
        mainViewModel = ViewModelProvider(
            this, MainViewModelFactory(RetrofitBuilder.apiService)
        )[MainViewModel::class.java]
    }

    private fun setupList() {
        mainListAdapter = MainListAdapter()

        dataListRv.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)

            adapter = mainListAdapter.withLoadStateFooter(
                footer = HeaderFooterAdapter()
            )
        }
    }

    private fun setupView() {
        lifecycleScope.launch {
            mainViewModel.listData.collect {
                mainListAdapter.submitData(it)
            }
        }
    }
}