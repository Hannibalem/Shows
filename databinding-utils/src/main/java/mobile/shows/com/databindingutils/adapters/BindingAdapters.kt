package mobile.shows.com.databindingutils.adapters

import android.databinding.BindingAdapter
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

@BindingAdapter("image")
fun ImageView._bindImage(imageUrl: String?) {
    imageUrl?.let {
        Glide.with(context)
                .load(it)
                .into(this)
    }
}

@BindingAdapter("visible")
fun View._bindVisible(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}