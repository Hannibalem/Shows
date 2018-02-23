package mobile.shows.com.shows.domain.model

data class Show(
        val id: Int,
        val name: String,
        val vote_average: Float,
        val overview: String,
        val poster_path: String
) {
    companion object {
        val EMPTY: Show = Show(0, "", 0f, "", "")
    }
}