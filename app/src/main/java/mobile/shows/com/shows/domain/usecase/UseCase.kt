package mobile.shows.com.shows.domain.usecase

import io.reactivex.Single

interface UseCase<ValueT> {

    fun execute(): Single<ValueT>
}