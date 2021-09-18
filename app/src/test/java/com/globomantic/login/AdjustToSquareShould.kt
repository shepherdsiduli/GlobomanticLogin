package com.globomantic.login

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class AdjustToSquareShould(private val tickRotation: Double, private val expectedResult: Double){

    private val adjustedToSquare = AdjustToSquare()

    companion object{
        @JvmStatic
        @Parameterized.Parameters
        fun data() = listOf(
            arrayOf(0.0, 1.0)
        )
    }

    @Test
    fun test(){
        assertEquals(adjustedToSquare(tickRotation), expectedResult, 0.000001)
    }
}