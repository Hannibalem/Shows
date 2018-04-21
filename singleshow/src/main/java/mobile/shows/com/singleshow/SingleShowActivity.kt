package mobile.shows.com.singleshow

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import dagger.android.AndroidInjection
import mobile.shows.com.commons.domain.entities.Show
import mobile.shows.com.singleshow.databinding.ActivitySingleShowBinding
import mobile.shows.com.singleshow.viewmodel.SingleShowViewModel
import javax.inject.Inject

private const val SHOW = "show"

internal class SingleShowActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: SingleShowViewModel

    lateinit var show: Show

    companion object {
        fun getIntent(context: Context, show: Show): Intent {
            val intent = Intent(context, SingleShowActivity::class.java)
            intent.putExtra(SHOW, Gson().toJson(show))
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        show = Gson().fromJson(intent.extras.getString(SHOW), Show::class.java)
        if (lastCustomNonConfigurationInstance != null) {
            viewModel = lastCustomNonConfigurationInstance as SingleShowViewModel
        } else {
            AndroidInjection.inject(this)
            viewModel.loadInitial()
        }
        val binding = DataBindingUtil.setContentView<ActivitySingleShowBinding>(this, R.layout.activity_single_show)
        binding.viewModel = viewModel
        binding.executePendingBindings()
    }

    override fun onSupportNavigateUp(): Boolean {
        viewModel.returnToMenu()
        return true
    }

    override fun onRetainCustomNonConfigurationInstance() = viewModel

    override fun onDestroy() {
        viewModel.destroy()
        super.onDestroy()
    }
}
