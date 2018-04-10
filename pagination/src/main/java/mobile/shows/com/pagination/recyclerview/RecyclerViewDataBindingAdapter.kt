package mobile.shows.com.shows.pagination.recyclerview

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

abstract class RecyclerViewDataBindingAdapter<in ModelT, BindingT: ViewDataBinding,
        HolderT: RecyclerViewDataBindingViewHolder<BindingT>>(
        private val context: Context,
        private var models: List<ModelT>
) : RecyclerView.Adapter<HolderT>() {

    final override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): HolderT {
        return getViewHolder(DataBindingUtil.inflate<BindingT>(LayoutInflater.from(context),
                getLayout(), parent, false))
    }

    override fun onBindViewHolder(holder: HolderT, position: Int) {
        bindItem(holder.binding, models[position])
        holder.binding.executePendingBindings()
    }

    final override fun getItemCount() = models.size

    abstract fun getLayout(): Int

    abstract fun getViewHolder(binding: BindingT): HolderT

    abstract fun bindItem(itemBinding: BindingT, model: ModelT)
}