package mobile.shows.com.commons.domain.usecases

import io.reactivex.Single

interface UseCase<ValueT> {

    fun execute(): Single<ValueT>
}