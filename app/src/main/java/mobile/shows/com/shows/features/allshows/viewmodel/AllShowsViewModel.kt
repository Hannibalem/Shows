package mobile.shows.com.shows.features.allshows.viewmodel

import android.databinding.BaseObservable
import android.databinding.Bindable
import io.reactivex.disposables.CompositeDisposable
import mobile.shows.com.commons.domain.usecases.ShowModel
import mobile.shows.com.commons.domain.usecases.ShowsModel
import mobile.shows.com.databindingutils.BindableDelegate
import mobile.shows.com.pagination.PagedDataSource
import mobile.shows.com.shows.BR
import mobile.shows.com.commons.domain.usecases.UseCase

class AllShowsViewModel(
        private val useCase: UseCase<ShowsModel>,
        @Bindable val dataSource: PagedDataSource<ShowModel, CardShowViewModel>
): BaseObservable() {

    private val disposables = CompositeDisposable()

    @get:Bindable
    var errorHappened by BindableDelegate(false, BR.errorHappened)

    @get:Bindable
    var loading by BindableDelegate(true, BR.loading)

    fun destroy() {
        disposables.clear()
        dataSource.clear()
    }

    fun loadInitial() = disposables.add(useCase.execute().subscribe(this::onPageLoaded, this::onError))

    fun retry() {
        loading = true
        errorHappened = false
        loadInitial()
    }

    private fun onPageLoaded(shows: ShowsModel) {
        dataSource.totalResults = shows.total
        dataSource.addNewItems(shows.list)
        this.loading = false
        notifyPropertyChanged(BR.dataSource)
    }

    private fun onError(throwable: Throwable) {
        throwable.printStackTrace()
        this.errorHappened = true
        this.loading = false
    }
}