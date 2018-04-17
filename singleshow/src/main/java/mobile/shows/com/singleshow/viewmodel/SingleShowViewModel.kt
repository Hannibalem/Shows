package mobile.shows.com.singleshow.viewmodel

import android.databinding.BaseObservable
import android.databinding.Bindable
import io.reactivex.disposables.CompositeDisposable
import mobile.shows.com.commons.domain.entities.Show
import mobile.shows.com.commons.domain.entities.Shows
import mobile.shows.com.databindingutils.BindableDelegate
import mobile.shows.com.pagination.PagedDataSource
import mobile.shows.com.commons.domain.usecases.UseCase
import mobile.shows.com.singleshow.BR
import mobile.shows.com.singleshow.domain.Navigator

class SingleShowViewModel(
        show: Show,
        private val useCase: UseCase<Shows>,
        private val navigator: Navigator,
        @Bindable val dataSource: PagedDataSource<Show, CardSimilarShowViewModel>
): BaseObservable() {

    private val disposables = CompositeDisposable()

    val imageUrl = "https://image.tmdb.org/t/p/w500${show.image_url}"

    val title = show.title

    val description = show.description

    @get:Bindable
    var loadingFinished by BindableDelegate(false, BR.loadingFinished)

    fun destroy() {
        disposables.clear()
        dataSource.clear()
    }

    fun loadInitial() = disposables.add(useCase.execute().subscribe(this::onPageLoaded, this::onError))

    fun returnToMenu() {
        navigator.startMainActivity()
    }

    private fun onPageLoaded(shows: Shows) {
        dataSource.totalResults = shows.total
        dataSource.addNewItems(shows.list)
        loadingFinished = true
        notifyPropertyChanged(BR.dataSource)
    }

    private fun onError(throwable: Throwable){
        throwable.printStackTrace()
    }
}