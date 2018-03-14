package mobile.shows.com.shows.features.singleshow.viewmodel

import android.databinding.BaseObservable
import android.databinding.Bindable
import mobile.shows.com.shows.BR
import mobile.shows.com.shows.domain.model.Show
import mobile.shows.com.shows.navigation.Navigator
import mobile.shows.com.shows.utilities.pagination.State
import mobile.shows.com.shows.utilities.pagination.WrapperWithState

class CardSimilarShowViewModel(private val navigator: Navigator): BaseObservable(), WrapperWithState<Show> {

    @get:Bindable
    override var state: State<Show> = State.Empty<Show>(Show.EMPTY)
        set(value) {
            if (field != value) {
                field = value
                notifyPropertyChanged(BR.state)
            }
        }

    @get:Bindable("state")
    val showUrl get() = "https://image.tmdb.org/t/p/w300${state.data?.poster_path}"

    fun onClick() { state.data?.let { navigator.startShowActivity(it) } }
}