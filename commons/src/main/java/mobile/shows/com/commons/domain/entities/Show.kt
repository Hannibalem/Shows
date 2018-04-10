package mobile.shows.com.commons.domain.entities

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