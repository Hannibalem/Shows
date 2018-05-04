package mobile.shows.com.singleshow.viewmodel

import mobile.shows.com.commons.domain.entities.Show
import mobile.shows.com.pagination.WrapperWithStateFactory
import mobile.shows.com.singleshow.navigation.Navigator

internal class CardSimilarShowViewModelFactory(
        private val navigator: Navigator
) : WrapperWithStateFactory<Show, CardSimilarShowViewModel> {

    override fun createWrapper() = CardSimilarShowViewModel(navigator)
}