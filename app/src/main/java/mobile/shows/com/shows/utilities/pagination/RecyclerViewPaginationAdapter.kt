package mobile.shows.com.shows.utilities.pagination

import android.content.Context
import android.databinding.ViewDataBinding
import io.reactivex.functions.Function
import mobile.shows.com.shows.utilities.pagination.recyclerview.RecyclerViewDataBindingAdapter
import mobile.shows.com.shows.utilities.pagination.recyclerview.RecyclerViewDataBindingViewHolder

abstract class RecyclerViewPaginationAdapter<ValueT, ModelT: WrapperWithState<ValueT>,
        BindingT: ViewDataBinding,
        HolderT: RecyclerViewDataBindingViewHolder<BindingT>>(
        context: Context,
        val dataSource: PagedDataSource<ValueT, ModelT>
) : RecyclerViewDataBindingAdapter<ModelT, BindingT, HolderT>(context, dataSource.pagedList) {

    init {
        dataSource.addDataChangedListener(Function { notifyItemChanged(it.size - 1) })
    }

    override fun onBindViewHolder(holder: HolderT, position: Int) {
        dataSource.getPageByPosition(position)
        super.onBindViewHolder(holder, position)
    }
}