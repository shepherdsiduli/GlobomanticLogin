package com.globomantic.login

import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.math.tan

class AdjustToSquare {
    operator fun invoke(tickRotation: Double): Double {
        if ((tickRotation >= kotlin.math.PI / 4 && tickRotation < 7 * kotlin.math.PI / 4) || (tickRotation >= 3 * kotlin.math.PI / 4 && tickRotation <= 7 * kotlin.math.PI / 4)) {
            return sqrt(1 + (tan(tickRotation).pow(2)))
        }

        if ((tickRotation >= kotlin.math.PI / 4 && tickRotation < 3 * kotlin.math.PI / 4) || (tickRotation >= 5 * kotlin.math.PI / 4 && tickRotation <= 7 * kotlin.math.PI / 4)) {
            return sqrt(1 + (1 / tan(tickRotation).pow(2)))
        }
        return 1.0
    }
}