package mobile.shows.com.shows.features.singleshow.viewmodel

import mobile.shows.com.shows.domain.model.Show
import mobile.shows.com.shows.navigation.Navigator
import mobile.shows.com.shows.utilities.pagination.WrapperWithStateFactory

class CardSimilarShowViewModelFactory(private val navigator: Navigator) : WrapperWithStateFactory<Show, CardSimilarShowViewModel> {

    override fun createWrapper() = CardSimilarShowViewModel(navigator)
}