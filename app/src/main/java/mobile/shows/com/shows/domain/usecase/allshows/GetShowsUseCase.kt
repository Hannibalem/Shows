package mobile.shows.com.shows.domain.usecase.allshows

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import mobile.shows.com.commons.domain.entities.Shows
import mobile.shows.com.commons.domain.usecases.UseCase
import mobile.shows.com.shows.domain.gateways.NetworkGateway

class GetShowsUseCase(private val networkGateway: NetworkGateway): UseCase<Shows> {

    override fun execute(): Single<Shows> {
        return networkGateway.getShows(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}