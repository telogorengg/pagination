package com.example.paginationlearning.data.datasource

import androidx.paging.PagingSource
import com.example.paginationlearning.data.api.ApiService
import com.example.paginationlearning.data.response.Data

class PostDataSource(private val apiService: ApiService) : PagingSource<Int, Data>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {
        try {
            val currentLoadingPageKey = params.key ?: 1
            val response = apiService.getListData(currentLoadingPageKey)
            val responseData = mutableListOf<Data>()
            val data = response.body()?.data ?: emptyList()
            responseData.addAll(data)

            val prevKey = if(currentLoadingPageKey == 1) null else currentLoadingPageKey - 1

            return LoadResult.Page(
                data = responseData,
                prevKey = prevKey,
                nextKey = currentLoadingPageKey.plus(1)
            )
        } catch(e: Exception) {
            return LoadResult.Error(e)
        }
    }
}