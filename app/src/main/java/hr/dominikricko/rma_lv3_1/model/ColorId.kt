package hr.dominikricko.rma_lv3_1.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import hr.dominikricko.rma_lv3_1.R

class ColorId(startingColor: Int) {

    private val _color = MutableLiveData(startingColor)
    val color : LiveData<Int>
        get() = _color

    fun resetColor(){
        _color.postValue(R.color.transparent)
    }

    fun setColor(colorId: Int){
        _color.postValue(colorId)
    }

}