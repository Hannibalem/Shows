package mobile.shows.com.pagination

interface WrapperWithState<ValueT> {

    var state: State<ValueT>

    fun onLoading() { state = State.Loading<ValueT>()
    }

    fun onEmpty() { state = State.Empty<ValueT>()
    }

    fun onLoaded(data: ValueT) { state = State.Data<ValueT>(data)
    }

    fun isEmpty() = state is State.Empty<ValueT>
}

sealed class State<out ValueT> {

    abstract val data: ValueT?

    data class Empty<out ValueT>(override val data: ValueT? = null) : State<ValueT>()

    data class Loading<out ValueT>(override val data: ValueT? = null) : State<ValueT>()

    data class Data<out ValueT>(override val data: ValueT) : State<ValueT>()
}

interface WrapperWithStateFactory<ValueT, out ModelT: WrapperWithState<ValueT>> {

    fun createWrapper(): ModelT

    fun createWrapperLoaded(value: ValueT) = createWrapper().apply { onLoaded(value) }
}