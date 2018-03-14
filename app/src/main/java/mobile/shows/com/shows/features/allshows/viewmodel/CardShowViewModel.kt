package mobile.shows.com.shows.features.allshows.viewmodel

import android.databinding.BaseObservable
import android.databinding.Bindable
import mobile.shows.com.shows.BR
import mobile.shows.com.shows.domain.usecase.Show
import mobile.shows.com.shows.navigation.Navigator
import mobile.shows.com.shows.utilities.pagination.State
import mobile.shows.com.shows.utilities.pagination.WrapperWithState

class CardShowViewModel(private val navigator: Navigator): BaseObservable(), WrapperWithState<Show> {

    @get:Bindable
    override var state: State<Show> = State.Empty<Show>(Show.EMPTY)
        set(value) {
            if (field != value) {
                field = value
                notifyPropertyChanged(BR.state)
            }
        }

    @get:Bindable("state")
    val showTitle get() = state.data?.title

    @get:Bindable("state")
    val showVote: String get() = state.data?.vote_average.toString()

    @get:Bindable("state")
    val showUrl get() = "https://image.tmdb.org/t/p/w300${state.data?.image_url}"

    fun onClick() { state.data?.let { navigator.startShowActivity(it) } }
}