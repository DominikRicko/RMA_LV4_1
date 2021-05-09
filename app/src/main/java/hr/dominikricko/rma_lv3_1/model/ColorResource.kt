package hr.dominikricko.rma_lv3_1.model

import android.content.res.Resources
import androidx.core.content.ContextCompat
import hr.dominikricko.rma_lv3_1.context.ApplicationContext
import hr.dominikricko.rma_lv3_1.persistence.CounterPreferencesManager

class ColorResource {

    var color : Int = 0
    get() {
        return try{
            ContextCompat.getColor(ApplicationContext.context, field)
        }catch (a : Resources.NotFoundException){
            0
        }

    }

    set(colorId) {
        CounterPreferencesManager.storedCounterColor = colorId
        field = colorId
    }

    init{
        this.color = CounterPreferencesManager.storedCounterColor
    }

    fun resetColor(){
        this.color = 0
    }

}