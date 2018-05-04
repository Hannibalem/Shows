package mobile.shows.com.singleshow.viewmodel

import android.databinding.BaseObservable
import android.databinding.Bindable
import mobile.shows.com.databindingutils.BindableDelegate
import mobile.shows.com.pagination.State
import mobile.shows.com.pagination.WrapperWithState
import mobile.shows.com.singleshow.BR
import mobile.shows.com.commons.domain.usecases.ShowModel
import mobile.shows.com.singleshow.navigation.Navigator

internal class CardSimilarShowViewModel(private val navigator: Navigator): BaseObservable(),
WrapperWithState<ShowModel> {

    @get:Bindable
    override var state: State<ShowModel> by BindableDelegate(State.Empty<ShowModel>(ShowModel.EMPTY), BR.state)

    @get:Bindable("state")
    val showUrl get() = "https://image.tmdb.org/t/p/w300${state.data?.image}"

    fun onClick() { state.data?.let { navigator.startShowActivity(it) } }
}