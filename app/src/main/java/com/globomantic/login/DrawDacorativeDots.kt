package com.globomantic.login

import android.content.res.Configuration
import android.graphics.Canvas
import android.graphics.Paint
import kotlin.math.cos
import kotlin.math.sin

class DrawDacorativeDots(
        private val adjustToSquare: AdjustToSquare,
        private val smallRadius: Float,
        private val largeRadius: Float,
        private val smallPaint: Paint,
        private val largePaint: Paint,
        private val dimen: Int
) {

    operator fun invoke(screenOrientation: Int, canvas: Canvas) {
        for (tickIndex in 0..79){
            val tickRotation = tickIndex * Math.PI / 40
            val adjust = if(SCREEN_ORIENTATION == Configuration.ORIENTATION_LANDSCAPE) adjustToSquare(tickRotation) else 1.0

            if(tickIndex % 20 == 0){
                val x = sin(tickRotation) * (dimen/2 - largeRadius) * adjust
                val y = -cos(tickRotation) * (dimen/2 - largeRadius) * adjust

                canvas.drawCircle(
                        (dimen/2 + x).toFloat(),
                        (dimen/2 + y).toFloat(),
                        largeRadius,
                        largePaint
                )
            } else{
                val x = sin(tickRotation) * (dimen/2 - largeRadius) * adjust
                val y = -cos(tickRotation) * (dimen/2 - largeRadius) * adjust
                canvas.drawCircle(
                        (dimen/2 + x).toFloat(),
                        (dimen/2 + y).toFloat(),
                        smallRadius,
                        smallPaint
                )
            }
        }
    }
}