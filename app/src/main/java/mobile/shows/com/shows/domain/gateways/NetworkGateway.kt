package mobile.shows.com.shows.domain.gateways

import io.reactivex.Single
import mobile.shows.com.commons.domain.entities.Shows

interface NetworkGateway {

    fun getShows(page: Int): Single<Shows>

    fun getSimilarShows(id: Int, page: Int): Single<Shows>
}