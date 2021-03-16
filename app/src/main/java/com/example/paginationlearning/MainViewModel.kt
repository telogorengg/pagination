package com.example.paginationlearning

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.paginationlearning.data.api.ApiService
import com.example.paginationlearning.data.datasource.PostDataSource

class MainViewModel(private val apiService: ApiService) : ViewModel() {
    val listData = Pager(PagingConfig(pageSize = 6)) {
        PostDataSource(apiService)
    }.flow.cachedIn(viewModelScope)
}