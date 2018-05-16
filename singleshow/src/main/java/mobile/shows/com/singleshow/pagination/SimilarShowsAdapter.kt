package mobile.shows.com.singleshow.pagination

import android.content.Context
import mobile.shows.com.commons.domain.usecases.ShowModel
import mobile.shows.com.pagination.PagedDataSource
import mobile.shows.com.pagination.RecyclerViewPaginationAdapter
import mobile.shows.com.singleshow.viewmodel.CardSimilarShowViewModel
import mobile.shows.com.singleshow.R
import mobile.shows.com.singleshow.databinding.CardSimilarShowBinding

internal class SimilarShowsAdapter(
        context: Context,
        dataSource: PagedDataSource<ShowModel, CardSimilarShowViewModel>
) : RecyclerViewPaginationAdapter<ShowModel, CardSimilarShowViewModel, CardSimilarShowBinding, SimilarShowViewHolder>(
        context,
        dataSource
) {
    override fun getLayout() = R.layout.card_similar_show

    override fun getViewHolder(binding: CardSimilarShowBinding) = SimilarShowViewHolder(binding)

    override fun bindItem(itemBinding: CardSimilarShowBinding, model: CardSimilarShowViewModel) {
        itemBinding.viewModel = model
    }
}