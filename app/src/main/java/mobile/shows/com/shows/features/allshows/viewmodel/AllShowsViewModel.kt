package mobile.shows.com.shows.features.allshows.viewmodel

import android.databinding.BaseObservable
import android.databinding.Bindable
import io.reactivex.disposables.CompositeDisposable
import mobile.shows.com.databindingutils.BindableDelegate
import mobile.shows.com.pagination.PagedDataSource
import mobile.shows.com.shows.BR
import mobile.shows.com.shows.domain.usecase.Show
import mobile.shows.com.shows.domain.usecase.Shows
import mobile.shows.com.shows.domain.usecase.UseCase

class AllShowsViewModel(
        private val useCase: UseCase<Shows>,
        @Bindable val dataSource: PagedDataSource<Show, CardShowViewModel>
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

    private fun onPageLoaded(shows: Shows) {
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