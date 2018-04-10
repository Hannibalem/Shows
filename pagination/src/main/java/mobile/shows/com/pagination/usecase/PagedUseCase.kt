package mobile.shows.com.shows.pagination.usecase

import io.reactivex.Single

interface PagedUseCase<ValueT> {

    fun execute(page: Int): Single<ValueT>
}