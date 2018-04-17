package mobile.shows.com.singleshow.viewmodel

import android.databinding.BaseObservable
import android.databinding.Bindable
import mobile.shows.com.commons.domain.entities.Show
import mobile.shows.com.databindingutils.BindableDelegate
import mobile.shows.com.pagination.State
import mobile.shows.com.pagination.WrapperWithState
import mobile.shows.com.singleshow.BR
import mobile.shows.com.singleshow.domain.Navigator

class CardSimilarShowViewModel(private val navigator: Navigator): BaseObservable(), WrapperWithState<Show> {

    @get:Bindable
    override var state: State<Show> by BindableDelegate(State.Empty<Show>(Show.EMPTY), BR.state)

    @get:Bindable("state")
    val showUrl get() = "https://image.tmdb.org/t/p/w300${state.data?.image_url}"

    fun onClick() { state.data?.let { navigator.startShowActivity(it) } }
}