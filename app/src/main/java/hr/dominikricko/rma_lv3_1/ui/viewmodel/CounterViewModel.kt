package hr.dominikricko.rma_lv3_1.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import hr.dominikricko.rma_lv3_1.R
import hr.dominikricko.rma_lv3_1.model.ColorResource
import hr.dominikricko.rma_lv3_1.model.Counter
import hr.dominikricko.rma_lv3_1.model.SimpleCounter
import hr.dominikricko.rma_lv3_1.persistence.CounterPreferencesManager

class CounterViewModel : ViewModel() {

    private val birdsCounter = MutableLiveData<Counter>(SimpleCounter(CounterPreferencesManager.storedCounterValue))
    private val displayColor = MutableLiveData(ColorResource(CounterPreferencesManager.storedCounterColor))

    val birdsSeen = Transformations.map(birdsCounter){it.counter}
    val birdColorSeen = Transformations.map(displayColor) {it.color}

    fun seeRedBird(){
        birdsCounter.value?.incrementCounter()
        displayColor.value?.color = R.color.red

    }

    fun seeBlueBird(){

        birdsCounter.value?.incrementCounter()
        displayColor.value?.color = R.color.blue
    }

    fun seeBrownBird(){
        birdsCounter.value?.incrementCounter()
        displayColor.value?.color = R.color.brown
    }

    fun seeGrayBird(){
        birdsCounter.value?.incrementCounter()
        displayColor.value?.color = R.color.gray
    }

    fun resetColor(){
        displayColor.value?.resetColor()
    }

    fun resetCounter(){
        birdsCounter.value?.resetCounter()
    }

}