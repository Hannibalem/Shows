package mobile.shows.com.shows.features.singleshow.databinding

import android.databinding.BindingAdapter
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import mobile.shows.com.pagination.PagedDataSource
import mobile.shows.com.shows.domain.usecase.Show
import mobile.shows.com.shows.features.singleshow.adapter.SimilarShowsAdapter
import mobile.shows.com.shows.features.singleshow.viewmodel.CardSimilarShowViewModel

@BindingAdapter("similar_shows")
fun RecyclerView._bindSimilarShowsDataSource(dataSource: PagedDataSource<Show, CardSimilarShowViewModel>?) {
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