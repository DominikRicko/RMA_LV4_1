package hr.dominikricko.rma_lv3_1.activities

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import hr.dominikricko.rma_lv3_1.R
import hr.dominikricko.rma_lv3_1.databinding.ActivityMainBinding
import hr.dominikricko.rma_lv3_1.counter.Counter
import hr.dominikricko.rma_lv3_1.counter.SimpleCounter
import hr.dominikricko.rma_lv3_1.observable.Observer
import hr.dominikricko.rma_lv3_1.preferences.CounterPreferencesManager

class MainActivity : AppCompatActivity(), Observer {

    private lateinit var binding : ActivityMainBinding
    private lateinit var counterDisplay : TextView
    private lateinit var counter : Counter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        counterDisplay = binding.tvBirdCounter

        initializeNewCounter(CounterPreferencesManager.storedCounterValue)
        updateCounterDisplayColor(CounterPreferencesManager.storedCounterColor)

        binding.btnBlueBird.setOnClickListener {
            counter.incrementCounter()
            updateCounterDisplayColor(R.color.blue)
        }

        binding.btnBrownBird.setOnClickListener {
            counter.incrementCounter()
            updateCounterDisplayColor(R.color.brown)
        }

        binding.btnRedBird.setOnClickListener {
            counter.incrementCounter()
            updateCounterDisplayColor(R.color.red)
        }

        binding.btnGrayBird.setOnClickListener {
            counter.incrementCounter()
            updateCounterDisplayColor(R.color.gray)
        }

        binding.btnResetColor.setOnClickListener {
            updateCounterDisplayColor(0)
        }

        binding.btnResetCounter.setOnClickListener {
            counter.resetCounter()
        }

        setContentView(binding.root)
    }

    private fun initializeNewCounter(startValue : Int){

        if(this::counter.isInitialized) counter.unsubscribe(this)

        counter = SimpleCounter(startValue)
        counter.subscribe(this)
        update()
    }

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

    override fun update() {
        counterDisplay.text = counter.counter.toString()
    }

}