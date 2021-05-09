package hr.dominikricko.rma_lv3_1.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hr.dominikricko.rma_lv3_1.databinding.ActivityMainBinding
import hr.dominikricko.rma_lv3_1.ui.viewmodel.CounterViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<CounterViewModel>()
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater).also{
            it.btnBlueBird.setOnClickListener { viewModel.seeBlueBird() }
            it.btnRedBird.setOnClickListener { viewModel.seeRedBird() }
            it.btnBrownBird.setOnClickListener { viewModel.seeBrownBird() }
            it.btnGrayBird.setOnClickListener { viewModel.seeGrayBird() }
            it.btnResetColor.setOnClickListener { viewModel.resetColor() }
            it.btnResetCounter.setOnClickListener { viewModel.resetCounter() }
        }

        setContentView(binding.root)

        viewModel.birdsCounter.observe(this, {binding.tvBirdCounter.text = it.toString()})
        viewModel.displayColor.observe(this,
            {binding.tvBirdCounter.setBackgroundColor(it.color)})


    }

}