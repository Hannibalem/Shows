package mobile.shows.com.shows.domain.gateways

import io.reactivex.Single
import mobile.shows.com.commons.domain.entities.Shows
import mobile.shows.com.singleshow.domain.NetworkGateway

interface NetworkGateway: NetworkGateway {

    fun getShows(page: Int): Single<Shows>
}