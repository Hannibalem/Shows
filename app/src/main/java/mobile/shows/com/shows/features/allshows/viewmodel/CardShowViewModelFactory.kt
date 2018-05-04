package mobile.shows.com.shows.features.allshows.viewmodel

import mobile.shows.com.commons.domain.usecases.ShowModel
import mobile.shows.com.pagination.WrapperWithStateFactory
import mobile.shows.com.shows.navigation.Navigator

class CardShowViewModelFactory(private val navigator: Navigator)
    : WrapperWithStateFactory<ShowModel, CardShowViewModel> {

    override fun createWrapper() = CardShowViewModel(navigator)
}