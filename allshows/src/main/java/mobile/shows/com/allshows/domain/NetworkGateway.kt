package mobile.shows.com.allshows.domain

import io.reactivex.Single
import mobile.shows.com.commons.domain.entities.Shows

interface NetworkGateway {

    fun getShows(page: Int): Single<Shows>
}