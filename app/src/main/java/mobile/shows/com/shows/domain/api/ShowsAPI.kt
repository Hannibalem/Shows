package mobile.shows.com.shows.domain.api

import mobile.shows.com.commons.domain.entities.Show
import mobile.shows.com.commons.domain.entities.Shows

data class ShowsAPI(
        val page: Int,
        val total_results: Int,
        val total_pages: Int,
        val results: List<ShowAPI>
)

data class ShowAPI(
        val id: Int,
        val name: String,
        val vote_average: Float,
        val overview: String,
        val poster_path: String
)

fun List<ShowAPI>.map(): List<Show>
        = this.map { Show(it.id, it.name, it.vote_average, it.overview ?: "", it.poster_path ?: "") }

fun ShowsAPI.map(): Shows = Shows(total_results, results.map())

