package mobile.shows.com.allshows

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import mobile.shows.com.allshows.databinding.ActivityAllShowsBinding
import mobile.shows.com.allshows.viewmodel.AllShowsViewModel
import javax.inject.Inject

internal class AllShowsActivity: AppCompatActivity() {

    @Inject
    lateinit var viewModel: AllShowsViewModel

    companion object {
        fun getIntent(context: Context) = Intent(context, AllShowsActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (lastCustomNonConfigurationInstance != null) {
            viewModel = lastCustomNonConfigurationInstance as AllShowsViewModel
        } else {
            AndroidInjection.inject(this)
            viewModel.loadInitial()
        }
        val binding = DataBindingUtil.setContentView<ActivityAllShowsBinding>(this, R.layout.activity_all_shows)
        binding.viewModel = viewModel
        binding.executePendingBindings()
    }

    override fun onRetainCustomNonConfigurationInstance() = viewModel

    override fun onDestroy() {
        viewModel.destroy()
        super.onDestroy()
    }
}