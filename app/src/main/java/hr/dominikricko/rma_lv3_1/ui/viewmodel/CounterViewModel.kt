package hr.dominikricko.rma_lv3_1.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hr.dominikricko.rma_lv3_1.model.ColorResource
import hr.dominikricko.rma_lv3_1.model.Counter
import hr.dominikricko.rma_lv3_1.persistence.CounterPreferencesManager

class CounterViewModel : ViewModel() {

    val redBirdsCounter = MutableLiveData<Counter>()
    val blueBirdsCounter = MutableLiveData<Counter>()
    val brownBirdsCounter = MutableLiveData<Counter>()
    val grayBirdsCounter = MutableLiveData<Counter>()

    val birdsCounter = MutableLiveData<Counter>()

    val displayColor = MutableLiveData<ColorResource>()

    fun seeRedBird(){
        redBirdsCounter.value?.incrementCounter()
        birdsCounter.value?.incrementCounter()
        CounterPreferencesManager.storedCounterValue = birdsCounter.value?.counter ?: 0
    }
    fun seeBlueBird(){
        redBirdsCounter.value?.incrementCounter()
        birdsCounter.value?.incrementCounter()
        CounterPreferencesManager.storedCounterValue = birdsCounter.value?.counter ?: 0
    }
    fun seeBrownBird(){
        redBirdsCounter.value?.incrementCounter()
        birdsCounter.value?.incrementCounter()
        CounterPreferencesManager.storedCounterValue = birdsCounter.value?.counter ?: 0
    }
    fun seeGrayBird(){
        redBirdsCounter.value?.incrementCounter()
        birdsCounter.value?.incrementCounter()
        CounterPreferencesManager.storedCounterValue = birdsCounter.value?.counter ?: 0
    }

}