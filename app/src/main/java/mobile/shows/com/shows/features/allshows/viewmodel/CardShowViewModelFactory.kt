package mobile.shows.com.shows.features.allshows.viewmodel

import mobile.shows.com.shows.domain.model.Show
import mobile.shows.com.shows.navigation.Navigator
import mobile.shows.com.shows.utilities.pagination.WrapperWithStateFactory

class CardShowViewModelFactory(private val navigator: Navigator)
    : WrapperWithStateFactory<Show, CardShowViewModel> {

    override fun createWrapper() = CardShowViewModel(navigator)
}