package hr.dominikricko.rma_lv3_1.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import hr.dominikricko.rma_lv3_1.model.Counter
import hr.dominikricko.rma_lv3_1.databinding.ActivityMainBinding
import hr.dominikricko.rma_lv3_1.ui.viewmodel.CounterViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<CounterViewModel>()

    private lateinit var binding : ActivityMainBinding

    private lateinit var counterDisplay : TextView
    private lateinit var counter : Counter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater).also{
            it.btnBlueBird.setOnClickListener { viewModel.seeBlueBird() }
            it.btnRedBird.setOnClickListener { viewModel.seeRedBird() }
            it.btnBrownBird.setOnClickListener { viewModel.seeBrownBird() }
            it.btnGrayBird.setOnClickListener { viewModel.seeGrayBird() }

            it.btnResetColor.setOnClickListener {}

            it.btnResetCounter.setOnClickListener {
                counter.resetCounter()
            }
        }

        counterDisplay = binding.tvBirdCounter

        setContentView(binding.root)

        viewModel.blueBirdsCounter.observe(this, {binding.tvBirdCounter.text = it.toString()})
        viewModel.redBirdsCounter.observe(this, {binding.tvBirdCounter.text = it.toString()})
        viewModel.grayBirdsCounter.observe(this, {binding.tvBirdCounter.text = it.toString()})
        viewModel.brownBirdsCounter.observe(this, {binding.tvBirdCounter.text = it.toString()})

    }

}