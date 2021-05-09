package hr.dominikricko.rma_lv3_1.utilities

import android.content.Context
import android.content.SharedPreferences
import hr.dominikricko.rma_lv3_1.context.ApplicationContext

object CounterPreferencesManager {

    const val PREFS_FILE = "BirdCounter"
    const val PREFS_KEY_COUNTERVALUE = "CounterValue"
    const val PREFS_KEY_COUNTERCOLOR = "CounterColor"

    private fun getPreferences(): SharedPreferences {
        return ApplicationContext.context.getSharedPreferences(
            PREFS_FILE, Context.MODE_PRIVATE
        )
    }

    var storedCounterValue: Int
        get() {
            return getPreferences().getInt(PREFS_KEY_COUNTERVALUE, 0)
        }
        set(value: Int) {
            getPreferences().edit()
                .putInt(PREFS_KEY_COUNTERVALUE, value)
                .apply()
        }

    var storedCounterColor: Int
        get() {
            return getPreferences().getInt(PREFS_KEY_COUNTERCOLOR, 0)
        }
        set(color: Int) {
            getPreferences().edit()
                .putInt(PREFS_KEY_COUNTERCOLOR, color)
                .apply()
        }

}