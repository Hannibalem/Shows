package mobile.shows.com.allshows.domain

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import mobile.shows.com.commons.domain.usecases.ShowModel
import mobile.shows.com.commons.domain.usecases.mapToModel
import mobile.shows.com.shows.pagination.usecase.PagedUseCase

internal class GetShowsByPageUseCase(private val networkGateway: NetworkGateway): PagedUseCase<List<ShowModel>> {

    override fun execute(page: Int): Single<List<ShowModel>> =
            networkGateway.getShows(page)
                    .map { it.list.map { it.mapToModel() } }
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
}