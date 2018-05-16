package mobile.shows.com.allshows.pagination

import android.content.Context
import mobile.shows.com.allshows.R
import mobile.shows.com.allshows.databinding.CardShowBinding
import mobile.shows.com.commons.domain.usecases.ShowModel
import mobile.shows.com.pagination.PagedDataSource
import mobile.shows.com.pagination.RecyclerViewPaginationAdapter
import mobile.shows.com.allshows.viewmodel.CardShowViewModel

internal class ShowsAdapter(
        context: Context,
        dataSource: PagedDataSource<ShowModel, CardShowViewModel>
) : RecyclerViewPaginationAdapter<ShowModel, CardShowViewModel, CardShowBinding, ShowViewHolder>(
        context,
        dataSource
) {
    override fun getLayout() = R.layout.card_show

    override fun getViewHolder(binding: CardShowBinding) = ShowViewHolder(binding)

    override fun bindItem(itemBinding: CardShowBinding, model: CardShowViewModel) {
        itemBinding.viewModel = model
    }
}