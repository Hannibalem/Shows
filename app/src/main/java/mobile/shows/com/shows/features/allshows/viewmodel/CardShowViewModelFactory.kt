package mobile.shows.com.shows.features.allshows.viewmodel

import mobile.shows.com.pagination.WrapperWithStateFactory
import mobile.shows.com.shows.domain.usecase.Show
import mobile.shows.com.shows.navigation.Navigator

class CardShowViewModelFactory(private val navigator: Navigator)
    : WrapperWithStateFactory<Show, CardShowViewModel> {

    override fun createWrapper() = CardShowViewModel(navigator)
}