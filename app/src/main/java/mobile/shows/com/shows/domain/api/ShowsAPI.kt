package mobile.shows.com.shows.domain.api

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