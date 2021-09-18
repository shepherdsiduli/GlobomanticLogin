package com.globomantic.login

import android.app.Application
import androidx.core.content.ContextCompat

class Globomantic : Application() {

    var largeColor: Int = 0
    var smallColor: Int = 0
    var shadowColor: Int = 0

    var shadowRadius: Float = 0f

    var largeRadius: Float = 0f
    var smallRadius: Float = 0f

    var logoSize: Int = 0

    override fun onCreate() {
        super.onCreate()

        largeColor = ContextCompat.getColor(this, R.color.largeColor)
        smallColor = ContextCompat.getColor(this, R.color.smallColor)
        shadowColor = ContextCompat.getColor(this, R.color.shadowColor)

        shadowRadius = resources.getDimension(R.dimen.shadow_radius)

        largeRadius = resources.getDimension(R.dimen.large_radius)
        smallRadius = resources.getDimension(R.dimen.small_radius)

        logoSize = resources.getDimension(R.dimen.logo_size).toInt()
    }
}