package mobile.shows.com.shows.utilities.pagination

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import mobile.shows.com.shows.utilities.pagination.usecase.PagedUseCase
import org.junit.Assert
import org.junit.Test

class PagedDataSourceTest {

    class Value

    class Model: WrapperWithState<Value> {
        override var data = Value()
        override var state = State.EMPTY
    }

    val useCase = mock<PagedUseCase<List<Value>>>()
    val factory = mock<WrapperWithStateFactory<Value, Model>>()
    val tested = PagedDataSource<Value, Model>(useCase, factory)


    @Test
    fun `Loaded page is created followed by an empty one`() {
        //Given
        val totalResults = 5
        tested.pageSize = 4
        tested.pagesPerChunk = 2
        tested.prefetchOffsetInItems = 2
        tested.totalResults = totalResults

        //When
        addBaseItems()

        //Then
        Assert.assertEquals(totalResults, tested.pagedList.size)
        Assert.assertEquals(State.LOADED, tested.pagedList[0].state)
        Assert.assertEquals(State.LOADED, tested.pagedList[1].state)
        Assert.assertEquals(State.LOADED, tested.pagedList[2].state)
        Assert.assertEquals(State.LOADED, tested.pagedList[3].state)
        Assert.assertEquals(State.EMPTY, tested.pagedList[4].state)
    }


    @Test
    fun `Page for position is loaded`() {
        //Given
        val totalResults = 5
        tested.pageSize = 4
        tested.pagesPerChunk = 2
        tested.prefetchOffsetInItems = 2
        tested.totalResults = totalResults

        val newValues = listOf<Value>(Value())
        whenever(useCase.execute(2)).thenReturn(Single.just(newValues))

        //When
        addBaseItems()
        tested.getPageByPosition(4)


        //Then
        verify(useCase).execute(2)
        Assert.assertEquals(totalResults, tested.pagedList.size)
        Assert.assertEquals(State.LOADED, tested.pagedList[4].state)
    }

    @Test
    fun `Next page is prefetched when a certain position is reached by scrolling to it`() {
        //Given
        val totalResults = 5
        tested.pageSize = 4
        tested.pagesPerChunk = 2
        tested.prefetchOffsetInItems = 3
        tested.totalResults = totalResults

        val newValues = listOf<Value>(Value())
        whenever(useCase.execute(2)).thenReturn(Single.just(newValues))

        //When
        addBaseItems()
        tested.getPageByPosition(1)

        //Then
        verify(useCase).execute(2)
        Assert.assertEquals(totalResults, tested.pagedList.size)
        Assert.assertEquals(State.LOADED, tested.pagedList[4].state)
    }

    fun addBaseItems() {
        val value = Value()
        val values = listOf<Value>(value, value, value, value)

        val modelLoaded = Model().apply { onLoaded(value) }
        val modelEmpty = Model()

        whenever(factory.createWrapper()).thenReturn(modelEmpty)
        whenever(factory.createWrapperLoaded(value)).thenReturn(modelLoaded)

        tested.addNewItems(values)
    }
}
