package mobile.shows.com.shows.domain.usecase.similarshows

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import mobile.shows.com.commons.domain.entities.Show
import mobile.shows.com.shows.pagination.usecase.PagedUseCase
import mobile.shows.com.shows.domain.api.ApiService
import mobile.shows.com.shows.domain.usecase.map

class GetSimilarShowsByPageUseCase(
        private val apiService: ApiService,
        private val showId: Int
) : PagedUseCase<List<Show>> {

    override fun execute(page: Int): Single<List<Show>> =
            apiService.getSimilarShows(showId, "6d38ef78b6c522d4282933d7514331f6", page)
                    .map { it.results.map() }
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
}