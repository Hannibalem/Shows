package mobile.shows.com.shows.features.singleshow.adapter

import android.content.Context
import mobile.shows.com.shows.R
import mobile.shows.com.shows.databinding.CardSimilarShowBinding
import mobile.shows.com.shows.domain.model.Show
import mobile.shows.com.shows.utilities.pagination.PagedDataSource
import mobile.shows.com.shows.utilities.pagination.RecyclerViewPaginationAdapter
import mobile.shows.com.shows.features.singleshow.viewmodel.CardSimilarShowViewModel

class SimilarShowsAdapter(
        context: Context,
        dataSource: PagedDataSource<Show, CardSimilarShowViewModel>
) : RecyclerViewPaginationAdapter<Show, CardSimilarShowViewModel, CardSimilarShowBinding, SimilarShowViewHolder>(
        context,
        dataSource
) {
    override fun getLayout() = R.layout.card_similar_show

    override fun getViewHolder(binding: CardSimilarShowBinding) = SimilarShowViewHolder(binding)

    override fun bindItem(itemBinding: CardSimilarShowBinding, model: CardSimilarShowViewModel) {
        itemBinding.viewModel = model
    }
}