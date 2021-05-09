package hr.dominikricko.rma_lv3_1.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hr.dominikricko.rma_lv3_1.counter.Counter

class CounterViewModel : ViewModel() {

    val redBirdsCounter = MutableLiveData<Counter>()
    val blueBirdsCounter = MutableLiveData<Counter>()
    val brownBirdsCounter = MutableLiveData<Counter>()
    val grayBirdsCounter = MutableLiveData<Counter>()

    fun seeRedBird() = redBirdsCounter.value?.incrementCounter()
    fun seeBlueBird() = redBirdsCounter.value?.incrementCounter()
    fun seeBrownBird() = redBirdsCounter.value?.incrementCounter()
    fun seeGrayBird() = redBirdsCounter.value?.incrementCounter()



}