package mobile.shows.com.shows.domain

import io.reactivex.Single
import mobile.shows.com.commons.domain.entities.Shows
import mobile.shows.com.shows.api.ApiService
import mobile.shows.com.shows.api.map

const val KEY = "6d38ef78b6c522d4282933d7514331f6"

class NetworkGatewayImpl(private val apiService: ApiService): NetworkGateway {

    override fun getShows(page: Int): Single<Shows> =
            apiService.getShows(KEY, page).map { it.map() }

    override fun getSimilarShows(id: Int, page: Int): Single<Shows> =
            apiService.getSimilarShows(id, KEY, page).map { it.map() }

}