package mobile.shows.com.allshows.databinding

import android.databinding.BindingAdapter
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import mobile.shows.com.allshows.pagination.ShowsAdapter
import mobile.shows.com.commons.domain.usecases.ShowModel
import mobile.shows.com.pagination.PagedDataSource
import mobile.shows.com.allshows.viewmodel.CardShowViewModel

@BindingAdapter("shows")
internal fun RecyclerView._bindShowsDataSource(dataSource: PagedDataSource<ShowModel, CardShowViewModel>?) {
    dataSource?.let {
        if (it.pagedList.isEmpty()) {
            return
        }
        if (adapter == null) {
            layoutManager = LinearLayoutManager(context)
            adapter = ShowsAdapter(context, it)
        }
    }
}