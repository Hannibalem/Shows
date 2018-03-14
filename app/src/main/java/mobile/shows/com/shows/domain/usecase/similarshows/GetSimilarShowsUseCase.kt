package mobile.shows.com.shows.domain.usecase.similarshows

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import mobile.shows.com.shows.domain.api.ApiService
import mobile.shows.com.shows.domain.usecase.Shows
import mobile.shows.com.shows.domain.usecase.UseCase
import mobile.shows.com.shows.domain.usecase.map

class GetSimilarShowsUseCase(
        private val apiService: ApiService,
        private val showId: Int
) : UseCase<Shows> {

    override fun execute(): Single<Shows> =
            apiService.getSimilarShows(showId, "6d38ef78b6c522d4282933d7514331f6", 1)
                    .map { Shows(it.total_results, it.results.map()) }
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
}