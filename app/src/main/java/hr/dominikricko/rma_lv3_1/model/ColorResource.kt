package hr.dominikricko.rma_lv3_1.model

import android.content.res.Resources
import androidx.core.content.ContextCompat
import hr.dominikricko.rma_lv3_1.context.ApplicationContext
import hr.dominikricko.rma_lv3_1.persistence.CounterPreferencesManager

class ColorResource {

    var colorId : Int
    get() {
        return try{
            ContextCompat.getColor(ApplicationContext.context,colorId)
        }catch (a : Resources.NotFoundException){
            0
        }

    }

    set(colorId) {
        CounterPreferencesManager.storedCounterColor = colorId
    }

    init{
        colorId = CounterPreferencesManager.storedCounterColor
    }

}