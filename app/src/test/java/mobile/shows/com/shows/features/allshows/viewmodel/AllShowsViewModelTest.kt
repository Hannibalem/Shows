package mobile.shows.com.shows.features.allshows.viewmodel

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import mobile.shows.com.shows.domain.model.Show
import mobile.shows.com.shows.domain.api.ShowsAPI
import mobile.shows.com.shows.utilities.pagination.PagedDataSource
import mobile.shows.com.shows.domain.usecase.UseCase
import org.junit.Assert
import org.junit.Test

class AllShowsViewModelTest {

    val useCase = mock<UseCase<ShowsAPI>>()
    val dataSource = mock<PagedDataSource<Show, CardShowViewModel>>()
    val tested = AllShowsViewModel(useCase, dataSource)

    @Test
    fun `UI updated when shows fetched`() {
        //Given
        val totalResults = 10
        val show = Show(1, "", 8f, "", "")
        val shows = listOf<Show>(show)
        val showsApi = ShowsAPI(1, totalResults, 1, shows)
        whenever(useCase.execute()).thenReturn(Single.just(showsApi))

        //When
        tested.loadInitial()

        //Then
        verify(dataSource).totalResults = totalResults
        verify(dataSource).addNewItems(showsApi.results)
        Assert.assertEquals(false, tested.loading)
        Assert.assertEquals(false, tested.errorHappened)
    }

    @Test
    fun `UI updated when error happens trying to fech shows`() {
        //Given
        whenever(useCase.execute()).thenReturn(Single.error(Throwable()))

        //When
        tested.loadInitial()

        //Then
        Assert.assertEquals(true, tested.errorHappened)
        Assert.assertEquals(false, tested.loading)
    }

    @Test
    fun `Shows fetched after retrying`() {
        //Given
        val totalResults = 10
        val show = Show(1, "", 8f, "", "")
        val shows = listOf<Show>(show)
        val showsApi = ShowsAPI(1, totalResults, 1, shows)
        whenever(useCase.execute()).thenReturn(Single.just(showsApi))

        //When
        tested.retry()

        //Then
        verify(dataSource).totalResults = totalResults
        verify(dataSource).addNewItems(showsApi.results)
        Assert.assertEquals(false, tested.loading)
        Assert.assertEquals(false, tested.errorHappened)
    }
}