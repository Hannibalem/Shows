package mobile.shows.com.shows.domain.api

import mobile.shows.com.shows.domain.model.Show

data class ShowsAPI(
        val page: Int,
        val total_results: Int,
        val total_pages: Int,
        val results: List<Show>
)