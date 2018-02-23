package mobile.shows.com.shows.features.allshows.databinding

import android.databinding.BindingAdapter
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import mobile.shows.com.shows.features.allshows.adapter.ShowsAdapter
import mobile.shows.com.shows.features.allshows.viewmodel.CardShowViewModel
import mobile.shows.com.shows.utilities.pagination.PagedDataSource
import mobile.shows.com.shows.domain.model.Show

@BindingAdapter("shows")
fun RecyclerView._bindShowsDataSource(dataSource: PagedDataSource<Show, CardShowViewModel>?) {
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