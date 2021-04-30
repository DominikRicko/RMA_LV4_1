package hr.dominikricko.rma_lv3_1.observable

interface Observable {

    val subscribers : Collection<Observer>

    fun subscribe(subscriber: Observer)
    fun unsubscribe(subscriber: Observer)

    fun notifySubscribers()

}