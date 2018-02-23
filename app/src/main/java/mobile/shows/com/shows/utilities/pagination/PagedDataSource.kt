package mobile.shows.com.shows.utilities.pagination

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Function
import mobile.shows.com.shows.utilities.pagination.usecase.PagedUseCase

const val DEFAULT_PAGE_SIZE = 20
const val DEFAULT_PAGES_PER_CHUNK = 2
const val DEFAULT_ITEMS_BEFORE_FETCH = 4

open class PagedDataSource<ValueT, ModelT: WrapperWithState<ValueT>>(
        private val useCase: PagedUseCase<List<ValueT>>,
        private val factory: WrapperWithStateFactory<ValueT, ModelT>
) {
    val pagedList = mutableListOf<ModelT>()
    var totalResults = 0
    var pageSize = DEFAULT_PAGE_SIZE
    var pagesPerChunk = DEFAULT_PAGES_PER_CHUNK
    var prefetchOffsetInItems = DEFAULT_ITEMS_BEFORE_FETCH

    private val listeners = mutableListOf<Function<List<ModelT>, Unit>>()
    private val disposables = CompositeDisposable()
    private var loadedChunks = 0
    private var totalCount = 0

    fun addDataChangedListener(listener: Function<List<ModelT>, Unit>) = listeners.add(listener)

    fun removeDataChangedListener(listener: Function<List<ModelT>, Unit>) = listeners.remove(listener)

    private fun notifyPropertyChanged() = listeners.forEach { it.apply(pagedList) }

    fun clear() {
        disposables.clear()
    }

    fun getPageByPosition(position: Int) {
        tryGetPageForPosition(position)
        tryPrefetchPageForPosition(position)
    }

    private fun tryGetPageForPosition(position: Int) {
        if (position < pagedList.size && pagedList[position].isEmpty()) {
            loadPage(calculatePageForItem(position))
        }
    }

    private fun tryPrefetchPageForPosition(position: Int) {
        if (position < pagedList.size && !pagedList[position].isEmpty() && shouldPrefetchNextPage(position)) {
            loadPage(calculatePageForItem(position) + 1)
        }
    }

    private fun calculatePageForItem(position: Int) = (position / pageSize) + 1

    private fun shouldPrefetchNextPage(position: Int)
            = isInPrefetchPosition(position) && !isPagePrefetch(position)

    private fun isInPrefetchPosition(position: Int)
            = pageSize - (position % pageSize) == prefetchOffsetInItems

    private fun isPagePrefetch(position: Int): Boolean {
        val page = calculatePageForItem(position) + 1
        val initialPosition = (page - 1) * pageSize
        return pagedList.size > initialPosition && !pagedList[initialPosition].isEmpty()
    }

    private fun loadPage(page: Int) {
        markPageItemsAsLoading(page)
        disposables.add(useCase.execute(page)
                .subscribe({ onPageLoaded(it, page) }, { onError(page)}))
    }

    private fun markPageItemsAsLoading(page: Int) {
        val initialPosition = (page - 1) * pageSize
        val finalPosition = Math.min(initialPosition + pageSize, totalCount)
        for (i in initialPosition..(finalPosition - 1)) {
            pagedList[i].onLoading()
        }
    }

    private fun onPageLoaded(result: List<ValueT>, page: Int) {
        if (isNewChunk(page)) {
            addNewItems(result)
        } else {
            loadItems(result, page)
        }
    }

    private fun isNewChunk(page: Int) = page == (loadedChunks * pagesPerChunk) + 1

    fun addNewItems(result: List<ValueT>) {
        this.loadedChunks++
        this.totalCount = Math.min((loadedChunks * pagesPerChunk * pageSize), totalResults)

        pagedList.addAll(result.map { factory.createWrapperLoaded(it) })

        val numberOfEmptyItems = Math.min((pagesPerChunk - 1) * pageSize, totalCount - pagedList.size)
        for (i in 1..numberOfEmptyItems) { pagedList.add(factory.createWrapper()) }

        notifyPropertyChanged()
    }

    private fun loadItems(result: List<ValueT>, page: Int) {
        val initialPosition = (page - 1) * pageSize
        val finalPosition = Math.min(initialPosition + pageSize, totalCount)
        var resultIndex = 0
        for (i in initialPosition until finalPosition) {
            pagedList[i].onLoaded(result[resultIndex++])
        }
    }

    private fun onError(page: Int) {
        val initialPosition = (page - 1) * pageSize
        val finalPosition = Math.min(initialPosition + pageSize, totalCount)
        for (i in initialPosition until finalPosition) {
            pagedList[i].onEmpty()
        }
    }
}