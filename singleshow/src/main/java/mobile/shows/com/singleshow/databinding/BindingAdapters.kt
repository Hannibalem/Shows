package mobile.shows.com.singleshow.databinding

import android.databinding.BindingAdapter
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import mobile.shows.com.commons.domain.entities.Show
import mobile.shows.com.pagination.PagedDataSource
import mobile.shows.com.singleshow.adapter.SimilarShowsAdapter
import mobile.shows.com.singleshow.viewmodel.CardSimilarShowViewModel

@BindingAdapter("similar_shows")
internal fun RecyclerView._bindSimilarShowsDataSource(dataSource: PagedDataSource<Show,
CardSimilarShowViewModel>?) {
    dataSource?.let {
        if (it.pagedList.isEmpty()) {
            return
        }
        if (adapter == null) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = SimilarShowsAdapter(context, it)
        }
    }
}