package mobile.shows.com.shows.domain.usecase

import mobile.shows.com.commons.domain.entities.Show
import mobile.shows.com.shows.domain.api.ShowAPI

data class Shows(val total: Int, val list: List<Show>)

fun List<ShowAPI>.map(): List<Show>
        = this.map { Show(it.id, it.name, it.vote_average, it.overview ?: "", it.poster_path ?: "") }