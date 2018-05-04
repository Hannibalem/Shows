package mobile.shows.com.singleshow.viewmodel

import mobile.shows.com.pagination.WrapperWithStateFactory
import mobile.shows.com.commons.domain.usecases.ShowModel
import mobile.shows.com.singleshow.navigation.Navigator

internal class CardSimilarShowViewModelFactory(
        private val navigator: Navigator
) : WrapperWithStateFactory<ShowModel, CardSimilarShowViewModel> {

    override fun createWrapper() = CardSimilarShowViewModel(navigator)
}