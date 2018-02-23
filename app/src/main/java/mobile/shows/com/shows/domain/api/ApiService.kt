package mobile.shows.com.shows.domain.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("tv/popular")
    fun getShows(@Query("api_key") key: String, @Query("page") page: Int): Single<ShowsAPI>

    @GET("tv/{id}/similar")
    fun getSimilarShows(@Path("id") id: Int, @Query("api_key") key: String, @Query("page") page: Int): Single<ShowsAPI>
}