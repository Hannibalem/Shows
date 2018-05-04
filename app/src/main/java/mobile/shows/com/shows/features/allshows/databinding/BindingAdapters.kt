package mobile.shows.com.shows.features.allshows.databinding

import android.databinding.BindingAdapter
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import mobile.shows.com.commons.domain.usecases.ShowModel
import mobile.shows.com.pagination.PagedDataSource
import mobile.shows.com.shows.features.allshows.adapter.ShowsAdapter
import mobile.shows.com.shows.features.allshows.viewmodel.CardShowViewModel

@BindingAdapter("shows")
fun RecyclerView._bindShowsDataSource(dataSource: PagedDataSource<ShowModel, CardShowViewModel>?) {
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