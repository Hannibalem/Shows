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
    override var data: Show = Show.EMPTY
        set(value) {
            if (field != value) {
                field = value
                notifyPropertyChanged(BR.data)
            }
        }

    @get:Bindable("data")
    val showUrl get() = "https://image.tmdb.org/t/p/w300${data.poster_path}"

    override var state = State.EMPTY

    fun onClick() {
        navigator.startShowActivity(data)
    }
}