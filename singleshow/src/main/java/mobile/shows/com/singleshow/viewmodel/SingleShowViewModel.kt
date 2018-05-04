package mobile.shows.com.singleshow.viewmodel

import android.databinding.BaseObservable
import android.databinding.Bindable
import io.reactivex.disposables.CompositeDisposable
import mobile.shows.com.databindingutils.BindableDelegate
import mobile.shows.com.pagination.PagedDataSource
import mobile.shows.com.commons.domain.usecases.UseCase
import mobile.shows.com.singleshow.BR
import mobile.shows.com.commons.domain.usecases.ShowModel
import mobile.shows.com.commons.domain.usecases.ShowsModel
import mobile.shows.com.singleshow.navigation.Navigator

internal class SingleShowViewModel(
        show: ShowModel,
        private val useCase: UseCase<ShowsModel>,
        private val navigator: Navigator,
        @Bindable val dataSource: PagedDataSource<ShowModel, CardSimilarShowViewModel>
): BaseObservable() {

    private val disposables = CompositeDisposable()

    val imageUrl = "https://image.tmdb.org/t/p/w500${show.image}"

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

    private fun onPageLoaded(shows: ShowsModel) {
        dataSource.totalResults = shows.total
        dataSource.addNewItems(shows.list)
        loadingFinished = true
        notifyPropertyChanged(BR.dataSource)
    }

    private fun onError(throwable: Throwable){
        throwable.printStackTrace()
    }
}