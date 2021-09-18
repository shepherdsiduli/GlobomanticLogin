package com.globomantic.login

import android.content.Context
import android.content.res.Configuration
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import java.lang.Math.PI
import kotlin.math.*

class LogoView : View {

    private lateinit var largePaint: Paint
    private lateinit var smallPaint: Paint
    private lateinit var drawDecorativeDots: DrawDacorativeDots
    private val dimen = (context.applicationContext as Globomantic).logoSize


    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        largePaint = Paint().apply {
            color = (context.applicationContext as Globomantic).largeColor
            isAntiAlias = true
            style = Paint.Style.FILL
            setShadowLayer(
                    (context.applicationContext as Globomantic).shadowRadius,
                    0f,
                    0f,
                    (context.applicationContext as Globomantic).shadowColor
            )
        }

        smallPaint = Paint().apply {
            color = (context.applicationContext as Globomantic).smallColor
            isAntiAlias = true
            style = Paint.Style.FILL
            setShadowLayer(
                    (context.applicationContext as Globomantic).shadowRadius,
                    0f,
                    0f,
                    (context.applicationContext as Globomantic).shadowColor
            )
        }

        val adjustToSquare = AdjustToSquare()

         val smallRadius = (context.applicationContext as Globomantic).smallRadius
         val largeRadius = (context.applicationContext as Globomantic).largeRadius

        drawDecorativeDots = DrawDacorativeDots(
                adjustToSquare,
                smallRadius,
                largeRadius,
                smallPaint,
                largePaint,
                dimen
        )
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val dimen = (context.applicationContext as Globomantic).logoSize

        val d: Drawable = ContextCompat.getDrawable(context, R.drawable.ic_launcher_background)!! //logo_globomatics

        d.setBounds((dimen/10).toInt(), (dimen / 10).toInt(), (9 * dimen / 10).toInt(),
            (9 * dimen / 10).toInt()
        )
        d.draw(canvas)

        drawDecorativeDots(SCREEN_ORIENTATION, canvas)
    }
}