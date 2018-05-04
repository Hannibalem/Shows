package mobile.shows.com.commons.domain.usecases

import mobile.shows.com.commons.domain.entities.Show
import mobile.shows.com.commons.domain.entities.Shows

data class ShowsModel(val total: Int, val list: List<ShowModel>)

data class ShowModel(
        val id: Int,
        val title: String,
        val vote_average: Float,
        val description: String,
        val image: String
) {
    companion object {
        val EMPTY: ShowModel = ShowModel(0, "", 0f, "", "")
    }
}

fun Shows.mapToModel() = ShowsModel(total, list.map { it.mapToModel() })

fun Show.mapToModel() = ShowModel(id, title, vote_average, description, image_url)