package mobile.shows.com.singleshow.domain

import io.reactivex.Single
import mobile.shows.com.commons.domain.entities.Shows

interface NetworkGateway {

    fun getSimilarShows(id: Int, page: Int): Single<Shows>
}