package hr.dominikricko.rma_lv3_1.model

import hr.dominikricko.rma_lv3_1.persistence.CounterPreferencesManager

class SimpleCounter(startingValue : Int) : Counter{

    companion object{
        operator fun invoke() = SimpleCounter(0)
    }

    private var _counter : Int = startingValue

    override val counter : Int
    get() = _counter

    override fun incrementCounter(){
        _counter++
        CounterPreferencesManager.storedCounterValue = _counter
    }

    override fun resetCounter(){
        _counter = 0
        CounterPreferencesManager.storedCounterValue = _counter
    }

}