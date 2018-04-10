package mobile.shows.com.shows.pagination.recyclerview

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

open class RecyclerViewDataBindingViewHolder<out BindingT: ViewDataBinding>(
        val binding: BindingT
) : RecyclerView.ViewHolder(binding.root)