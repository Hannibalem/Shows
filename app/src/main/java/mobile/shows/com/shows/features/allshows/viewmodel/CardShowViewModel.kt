package mobile.shows.com.shows.features.allshows.viewmodel

import android.databinding.BaseObservable
import android.databinding.Bindable
import mobile.shows.com.commons.domain.usecases.ShowModel
import mobile.shows.com.databindingutils.BindableDelegate
import mobile.shows.com.pagination.State
import mobile.shows.com.pagination.WrapperWithState
import mobile.shows.com.shows.BR
import mobile.shows.com.shows.navigation.Navigator

class CardShowViewModel(private val navigator: Navigator): BaseObservable(), WrapperWithState<ShowModel> {

    @get:Bindable
    override var state: State<ShowModel> by BindableDelegate(State.Empty<ShowModel>(ShowModel.EMPTY), BR.state)

    @get:Bindable("state")
    val showTitle get() = state.data?.title

    @get:Bindable("state")
    val showVote get() = state.data?.vote_average.toString()

    @get:Bindable("state")
    val showUrl get() = "https://image.tmdb.org/t/p/w300${state.data?.image}"

    fun onClick() { state.data?.let { navigator.startShowActivity(it) } }
}