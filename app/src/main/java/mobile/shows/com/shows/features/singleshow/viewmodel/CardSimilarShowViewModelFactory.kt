package mobile.shows.com.shows.features.singleshow.viewmodel

import mobile.shows.com.pagination.WrapperWithStateFactory
import mobile.shows.com.shows.domain.usecase.Show
import mobile.shows.com.shows.navigation.Navigator

class CardSimilarShowViewModelFactory(
        private val navigator: Navigator
) : WrapperWithStateFactory<Show, CardSimilarShowViewModel> {

    override fun createWrapper() = CardSimilarShowViewModel(navigator)
}