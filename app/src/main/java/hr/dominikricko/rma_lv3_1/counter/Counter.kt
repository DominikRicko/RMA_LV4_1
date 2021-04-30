package hr.dominikricko.rma_lv3_1.counter

import hr.dominikricko.rma_lv3_1.observable.Observable

interface Counter : Observable{

    val counter : Int
    fun incrementCounter()
    fun resetCounter()

}