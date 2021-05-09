package hr.dominikricko.rma_lv3_1.ui.viewmodel

import androidx.lifecycle.ViewModel
import hr.dominikricko.rma_lv3_1.R
import hr.dominikricko.rma_lv3_1.model.ColorId
import hr.dominikricko.rma_lv3_1.model.SimpleCounter
import hr.dominikricko.rma_lv3_1.utilities.CounterPreferencesManager

class CounterViewModel : ViewModel() {

    private val birdsCounter = SimpleCounter(CounterPreferencesManager.storedCounterValue)
    private val displayColor = ColorId(CounterPreferencesManager.storedCounterColor)

    val birdsSeen = birdsCounter.counter
    val birdColorSeen = displayColor.color

    fun seeRedBird(){
        birdsCounter.incrementCounter()
        displayColor.setColor(R.color.red)

    }

    fun seeBlueBird(){

        birdsCounter.incrementCounter()
        displayColor.setColor(R.color.blue)
    }

    fun seeBrownBird(){
        birdsCounter.incrementCounter()
        displayColor.setColor(R.color.brown)
    }

    fun seeGrayBird(){
        birdsCounter.incrementCounter()
        displayColor.setColor(R.color.gray)
    }

    fun resetColor(){
        displayColor.resetColor()
    }

    fun resetCounter(){
        birdsCounter.resetCounter()
    }

}