package com.igorwojda.integer.digitfrequency

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun equalDigitFrequency(i1: Int, i2: Int): Boolean {
    val i1Str = i1.toString()
    val i2Str = i2.toString()

    if (i1Str.length != i2Str.length) return false

    val frequency1 = i1Str
        .groupingBy { it }
        .eachCount()
    val frequency2 = i2Str
        .groupingBy { it }
        .eachCount()

    return frequency1 == frequency2
}

private class Test {
    @Test
    fun `"789" and "897" have the same digit frequency`() {
        equalDigitFrequency(789, 897) shouldBeEqualTo true
    }

    @Test
    fun `"123445" and "451243" have the same digit frequency`() {
        equalDigitFrequency(123445, 451243) shouldBeEqualTo true
    }

    @Test
    fun `"447" and "477" have different digit frequency"`() {
        equalDigitFrequency(447, 477) shouldBeEqualTo false
    }

    @Test
    fun `"578" and "0" have different digit frequency"`() {
        equalDigitFrequency(578, 0) shouldBeEqualTo false
    }

    @Test
    fun `"0" and "0" have the same digit frequency"`() {
        equalDigitFrequency(0, 0) shouldBeEqualTo true
    }
}
