package mobile.shows.com.shows.utilities.pagination

enum class State {
    EMPTY, LOADED, LOADING
}

interface WrapperWithState<ValueT> {

    var state: State
    var data: ValueT

    fun onLoaded(data: ValueT) {
        this.data = data
        state = State.LOADED
    }

    fun onEmpty() {
        state = State.EMPTY
    }

    fun onLoading() {
        state = State.LOADING
    }

    fun isEmpty() = state == State.EMPTY
}

interface WrapperWithStateFactory<ValueT, out ModelT: WrapperWithState<ValueT>> {

    fun createWrapper(): ModelT

    fun createWrapperLoaded(value: ValueT) = createWrapper().apply { onLoaded(value) }
}