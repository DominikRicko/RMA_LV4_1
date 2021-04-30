package hr.dominikricko.rma_lv3_1.counter

import hr.dominikricko.rma_lv3_1.observable.Observer

class SimpleCounter(startingValue : Int) : Counter{

    companion object{
        operator fun invoke() = SimpleCounter(0)
    }

    private var _counter : Int = startingValue

    override val counter : Int
    get() = _counter

    override fun incrementCounter(){
        _counter++
        notifySubscribers()
    }

    override fun resetCounter(){
        _counter = 0
        notifySubscribers()
    }

    private val _subscribers = ArrayList<Observer>()

    override val subscribers: Collection<Observer>
        get() = _subscribers

    override fun subscribe(subscriber: Observer) {
        _subscribers.add(subscriber)
    }

    override fun unsubscribe(subscriber: Observer) {
        _subscribers.remove(subscriber)
    }

    override fun notifySubscribers() {
        _subscribers.forEach { it.update() }
    }

}