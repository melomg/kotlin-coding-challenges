package com.igorwojda.integer.factorial

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

private fun factorial(n: Int): Int = when {
    (n < 0) -> throw IllegalArgumentException("Argument cannot be lower than zero...")
    (n == 0 || n == 1) -> 1
    else -> n.downTo(1).reduce { acc, i -> acc * i }
}

class RecursiveFactorial {
    @Test
    fun `factorial 0 should equal 1`() {
        factorial(0) shouldBeEqualTo 1
    }

    @Test
    fun `factorial 1 should equal 1`() {
        factorial(1) shouldBeEqualTo 1
    }

    @Test
    fun `factorial 3 should equal 6`() {
        factorial(3) shouldBeEqualTo 6
    }

    @Test
    fun `factorial 5 should equal 120`() {
        factorial(5) shouldBeEqualTo 120
    }

    @Test
    fun `factorial 10 should equal 3628800`() {
        factorial(10) shouldBeEqualTo 3628800
    }
}
