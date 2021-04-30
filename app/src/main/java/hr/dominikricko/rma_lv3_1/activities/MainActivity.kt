package hr.dominikricko.rma_lv3_1.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import hr.dominikricko.rma_lv3_1.R
import hr.dominikricko.rma_lv3_1.databinding.ActivityMainBinding
import hr.dominikricko.rma_lv3_1.counter.Counter
import hr.dominikricko.rma_lv3_1.counter.SimpleCounter
import hr.dominikricko.rma_lv3_1.observable.Observer

class MainActivity : AppCompatActivity(), Observer {

    private lateinit var binding : ActivityMainBinding
    private lateinit var counterDisplay : TextView
    private lateinit var counter : Counter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        counterDisplay = binding.tvBirdCounter

        initializeNewCounter(0)

        binding.btnBlueBird.setOnClickListener {
            counter.incrementCounter()
            counterDisplay.setBackgroundColor(getColor(R.color.blue))
        }

        binding.btnBrownBird.setOnClickListener {
            counter.incrementCounter()
            counterDisplay.setBackgroundColor(getColor(R.color.brown))
        }

        binding.btnRedBird.setOnClickListener {
            counter.incrementCounter()
            counterDisplay.setBackgroundColor(getColor(R.color.red))
        }

        binding.btnGrayBird.setOnClickListener {
            counter.incrementCounter()
            counterDisplay.setBackgroundColor(getColor(R.color.gray))
        }

        binding.btnResetColor.setOnClickListener {
            counterDisplay.setBackgroundColor(0)
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
    }

    override fun update() {
        counterDisplay.text = counter.counter.toString()
    }

}