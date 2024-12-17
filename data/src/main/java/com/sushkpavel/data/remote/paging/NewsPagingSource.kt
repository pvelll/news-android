package com.sushkpavel.data.remote.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.sushkpavel.data.BuildConfig
import com.sushkpavel.data.remote.model.NewsDto
import com.sushkpavel.data.utils.Utils.HEADLINES_END_POINT
import com.sushkpavel.data.utils.Utils.PAGE_SIZE
import com.sushkpavel.domain.model.News
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.request.parameter
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json

class NewsPagingSource(
    private val client: HttpClient,
    private val country: String?,
    private val category: String?,
    private val query: String?
) : PagingSource<Int, News>() {
    override fun getRefreshKey(state: PagingState<Int, News>): Int? = state.anchorPosition

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, News> {
        return try {
            val nextPage = params.key ?: FIRST_PAGE_INDEX
            val response = Json.decodeFromString<NewsDto>(
                client.get(HEADLINES_END_POINT) {
                    parameter("country", country)
                    parameter("category", category)
                    parameter("q", query)
                    parameter("pageSize", PAGE_SIZE)
                    parameter("page", nextPage)
                    headers {
                        append("X-Api-Key", BuildConfig.API_KEY)
                    }
                }.bodyAsText()
            )
            LoadResult.Page(
                data = response.articles.map { it },
                prevKey = if (nextPage == FIRST_PAGE_INDEX) null else nextPage - 1,
                nextKey = if (response.articles.isEmpty()) null else nextPage + 1
            )
        } catch (exception: Exception) {
            return LoadResult.Error(exception)
        }
    }

    companion object {
        const val FIRST_PAGE_INDEX = 0
    }
}