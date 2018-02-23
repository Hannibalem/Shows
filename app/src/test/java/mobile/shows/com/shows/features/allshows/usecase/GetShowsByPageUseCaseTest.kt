package mobile.shows.com.shows.features.allshows.usecase

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.observers.TestObserver
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import mobile.shows.com.shows.domain.model.Show
import mobile.shows.com.shows.domain.api.ShowsAPI
import mobile.shows.com.shows.domain.api.ApiService
import mobile.shows.com.shows.domain.usecase.allshows.GetShowsByPageUseCase
import org.junit.BeforeClass
import org.junit.Test

class GetShowsByPageUseCaseTest {

    val api = mock<ApiService>()
    val tested = GetShowsByPageUseCase(api)

    companion object {

        @BeforeClass
        @JvmStatic
        fun setupClass() {
            RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
            RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        }
    }

    @Test
    fun `Shows are retrieved`() {
        //Given
        val page = 1
        val show1 = Show(1, "", 8f, "", "")
        val show2 = Show(2, "", 9f, "", "")
        val shows = listOf<Show>(show1, show2)
        val showsApi = ShowsAPI(page, 2, 1, shows)

        whenever(api.getShows("6d38ef78b6c522d4282933d7514331f6", page)).thenReturn(Single.just(showsApi))

        val subscriber = TestObserver<List<Show>>()

        //Then
        tested.execute(page).subscribe(subscriber)

        //When
        subscriber.awaitTerminalEvent()
        subscriber.assertNoErrors()
        subscriber.assertValue { it.size == 2 }
        subscriber.assertValue { it[0] == show1 && it[1] == show2 }
    }
}