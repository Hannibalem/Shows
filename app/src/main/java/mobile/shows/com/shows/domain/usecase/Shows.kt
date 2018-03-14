package mobile.shows.com.shows.domain.usecase

import mobile.shows.com.shows.domain.api.ShowAPI

data class Shows(val total: Int, val list: List<Show>)

data class Show(
        val id: Int,
        val title: String,
        val vote_average: Float,
        val description: String,
        val image_url: String
) {
    companion object {
        val EMPTY: Show = Show(0, "", 0f, "", "")
    }
}

fun List<ShowAPI>.map(): List<Show>
        = this.map { Show(it.id, it.name, it.vote_average, it.overview, it.poster_path) }