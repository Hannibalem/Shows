package mobile.shows.com.shows.features.allshows.adapter

import android.content.Context
import mobile.shows.com.shows.R
import mobile.shows.com.shows.databinding.CardShowBinding
import mobile.shows.com.shows.features.allshows.viewmodel.CardShowViewModel
import mobile.shows.com.shows.utilities.pagination.PagedDataSource
import mobile.shows.com.shows.domain.model.Show
import mobile.shows.com.shows.utilities.pagination.RecyclerViewPaginationAdapter

class ShowsAdapter(
        context: Context,
        dataSource: PagedDataSource<Show, CardShowViewModel>
) : RecyclerViewPaginationAdapter<Show, CardShowViewModel, CardShowBinding, ShowViewHolder>(
        context,
        dataSource
) {
    override fun getLayout() = R.layout.card_show

    override fun getViewHolder(binding: CardShowBinding) = ShowViewHolder(binding)

    override fun bindItem(itemBinding: CardShowBinding, model: CardShowViewModel) {
        itemBinding.viewModel = model
    }
}