package hr.dominikricko.rma_lv3_1.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import hr.dominikricko.rma_lv3_1.utilities.CounterPreferencesManager

class SimpleCounter(startingValue : Int): LiveData<Int>() {

    companion object{
        operator fun invoke() = SimpleCounter(0)
    }

    private val _counter = MutableLiveData(startingValue)
    val counter : LiveData<Int>
    get() = _counter

    fun incrementCounter(){
        _counter.value?.let {
            val newValue = it + 1
            _counter.postValue(newValue)
            CounterPreferencesManager.storedCounterValue = newValue
        }

    }

    fun resetCounter(){
        _counter.value?.let {
            val newValue = 0
            _counter.postValue(newValue)
            CounterPreferencesManager.storedCounterValue = newValue
        }
    }

}