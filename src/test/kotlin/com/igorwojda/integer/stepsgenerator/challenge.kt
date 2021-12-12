package com.igorwojda.integer.stepsgenerator

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private const val HASH_SYMBOL: Char = '#'
private const val SPACE: Char = ' '

fun generateSteps(n: Int): List<String> {
    if (n <= 0) return emptyList()

    val result = mutableListOf<String>()

    (0 until n).forEach { i ->
        val symbolCount = i + 1
        val spaceCount = (n - symbolCount)

        var spaces = ""
        var symbols = ""

        repeat(spaceCount) { spaces += SPACE }
        repeat(symbolCount) { symbols += HASH_SYMBOL }

        result.add("$symbols$spaces")
    }

    return result
}

private class Test {
    @Test
    fun `steps n = 1`() {
        val actual = generateSteps(1)
        actual.size shouldBeEqualTo 1
        actual[0] shouldBeEqualTo "#"
    }

    @Test
    fun `steps n = 2`() {
        val actual = generateSteps(2)
        actual.size shouldBeEqualTo 2
        actual[0] shouldBeEqualTo "# "
        actual[1] shouldBeEqualTo "##"
    }

    @Test
    fun `steps n = 3`() {
        val actual = generateSteps(3)
        actual.size shouldBeEqualTo 3
        actual[0] shouldBeEqualTo "#  "
        actual[1] shouldBeEqualTo "## "
        actual[2] shouldBeEqualTo "###"
    }
}
