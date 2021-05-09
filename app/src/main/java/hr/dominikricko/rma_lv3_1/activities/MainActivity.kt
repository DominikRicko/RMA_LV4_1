package hr.dominikricko.rma_lv3_1.activities

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import hr.dominikricko.rma_lv3_1.counter.Counter
import hr.dominikricko.rma_lv3_1.databinding.ActivityMainBinding
import hr.dominikricko.rma_lv3_1.preferences.CounterPreferencesManager
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

            it.btnResetColor.setOnClickListener {
                //updateCounterDisplayColor(0)
            }

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
/*
    private fun updateCounterDisplayColor(color : Int){
        try {
            val resolvedColor = getColor(color)
            counterDisplay.setBackgroundColor(resolvedColor)
            CounterPreferencesManager.storedCounterColor = color
        }catch (a : Resources.NotFoundException){
            counterDisplay.setBackgroundColor(0)
            CounterPreferencesManager.storedCounterColor = 0
        }

    }
*/
}