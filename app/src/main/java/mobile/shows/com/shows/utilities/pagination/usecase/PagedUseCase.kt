package mobile.shows.com.shows.utilities.pagination.usecase

import io.reactivex.Single

interface PagedUseCase<ValueT> {

    fun execute(page: Int): Single<ValueT>
}