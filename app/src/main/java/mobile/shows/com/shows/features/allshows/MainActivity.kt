package mobile.shows.com.shows.features.allshows

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import dagger.android.AndroidInjection
import mobile.shows.com.shows.R
import mobile.shows.com.shows.databinding.ActivityMainBinding
import mobile.shows.com.shows.features.allshows.viewmodel.AllShowsViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: AllShowsViewModel

    companion object {
        fun getIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (lastCustomNonConfigurationInstance != null) {
            viewModel = lastCustomNonConfigurationInstance as AllShowsViewModel
        } else {
            AndroidInjection.inject(this)
            viewModel.loadInitial()
        }
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.executePendingBindings()
    }

    override fun onRetainCustomNonConfigurationInstance() = viewModel

    override fun onDestroy() {
        viewModel.destroy()
        super.onDestroy()
    }
}
