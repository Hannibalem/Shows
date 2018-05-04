package mobile.shows.com.allshows.viewmodel

import mobile.shows.com.allshows.navigation.Navigator
import mobile.shows.com.commons.domain.usecases.ShowModel
import mobile.shows.com.pagination.WrapperWithStateFactory

internal class CardShowViewModelFactory(private val navigator: Navigator)
    : WrapperWithStateFactory<ShowModel, CardShowViewModel> {

    override fun createWrapper() = CardShowViewModel(navigator)
}