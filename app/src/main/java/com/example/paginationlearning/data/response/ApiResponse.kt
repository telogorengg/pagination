package com.example.paginationlearning.data.response

import com.squareup.moshi.Json

data class ApiResponse(
    @Json(name = "ad")
    val ad: Ad? = null,
    @Json(name = "data")
    val data: List<Data>,
    @Json(name = "per_page")
    val perPage: Int,
    @Json(name = "total")
    val total: Int,
    @Json(name = "total_pages")
    val totalPages: Int
)