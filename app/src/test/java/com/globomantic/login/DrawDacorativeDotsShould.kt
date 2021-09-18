package com.globomantic.login

import android.content.res.Configuration
import android.graphics.Canvas
import android.graphics.Paint
import io.mockk.mockk
import io.mockk.verify
import junit.framework.TestCase
import org.junit.Test

class DrawDacorativeDotsShould {

    private val adjustToSquareMock = mockk<AdjustToSquare>(relaxed = true)
    private val smallPaintMock = mockk<Paint>(relaxed = true)
    private val largePaintMock = mockk<Paint>(relaxed = true)
    private val smallRadius = 1f
    private val largeRadius = 2f
    private val dimen = 256


    private val drawDecorativeDots = DrawDacorativeDots(
        adjustToSquareMock,
        smallRadius,
        largeRadius,
        smallPaintMock,
        largePaintMock,
        dimen
    )

    private val canvasMock = mockk<Canvas>(relaxed = true)

    @Test
    fun draw80Dots() {
        drawDecorativeDots(Configuration.ORIENTATION_LANDSCAPE, canvasMock)
        verify(exactly = 80) {
            canvasMock.drawCircle(any(), any(), any(), any())
        }
    }

    @Test
    fun draw4BigDots_and76SmallDots() {
        drawDecorativeDots(Configuration.ORIENTATION_LANDSCAPE, canvasMock)
        verify(exactly = 76) { canvasMock.drawCircle(any(), any(), smallRadius, smallPaintMock) }
        verify(exactly = 4) { canvasMock.drawCircle(any(), any(), largeRadius, largePaintMock) }
    }

    @Test
    fun notUsedAdjustSquare_inPortableOrientation() {
        drawDecorativeDots(Configuration.ORIENTATION_PORTRAIT, canvasMock)
        verify(exactly = 0) { adjustToSquareMock.invoke(any()) }
    }

  //  @Test
    fun notUsedAdjustSquare_inLandscapeOrientation() {
        drawDecorativeDots(Configuration.ORIENTATION_LANDSCAPE, canvasMock)
        verify(exactly = 80) { adjustToSquareMock.invoke(any()) }
    }
}