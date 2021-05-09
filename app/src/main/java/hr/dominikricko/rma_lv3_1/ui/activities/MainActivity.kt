package hr.dominikricko.rma_lv3_1.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import hr.dominikricko.rma_lv3_1.R
import hr.dominikricko.rma_lv3_1.databinding.ActivityMainBinding
import hr.dominikricko.rma_lv3_1.ui.viewmodel.CounterViewModel
import hr.dominikricko.rma_lv3_1.utilities.ColorResourceGetter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<CounterViewModel>()
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.also{
            it.btnBlueBird.setOnClickListener { viewModel.seeBlueBird() }
            it.btnRedBird.setOnClickListener { viewModel.seeRedBird() }
            it.btnBrownBird.setOnClickListener { viewModel.seeBrownBird() }
            it.btnGrayBird.setOnClickListener { viewModel.seeGrayBird() }
            it.btnResetColor.setOnClickListener { viewModel.resetColor() }
            it.btnResetCounter.setOnClickListener { viewModel.resetCounter() }
        }

        viewModel.birdColorSeen.observe(this)
        {binding.tvBirdCounter.setBackgroundColor(ColorResourceGetter.getColor(it))}

    }

}