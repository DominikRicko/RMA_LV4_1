package hr.dominikricko.rma_lv3_1.utilities

import android.content.res.Resources
import androidx.core.content.ContextCompat
import hr.dominikricko.rma_lv3_1.context.ApplicationContext

object ColorResourceGetter {

    fun getColor(colorId: Int) : Int {
        return try {
            ContextCompat.getColor(ApplicationContext.context, colorId)
        } catch (a: Resources.NotFoundException) {
            0
        }
    }

}