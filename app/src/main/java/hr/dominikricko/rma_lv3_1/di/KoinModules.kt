package hr.dominikricko.rma_lv3_1.di

import hr.dominikricko.rma_lv3_1.model.Counter
import hr.dominikricko.rma_lv3_1.model.SimpleCounter
import hr.dominikricko.rma_lv3_1.ui.viewmodel.CounterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module{
    factory<Counter>{ SimpleCounter() }
}

val viewModel = module{
    viewModel {CounterViewModel()}
}