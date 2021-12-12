package com.igorwojda.integer.pyramidgenerator

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private const val PYRAMID_SYMBOL: Char = '#'
private const val SPACE: Char = ' '

fun generatePyramid(n: Int): List<String> {
    if (n <= 0) return emptyList()

    val result = mutableListOf<String>()
    val lastCharCount = 1 + (n - 1) * 2

    (0 until n).forEach { i ->
        val symbolCount = (i * 2) + 1
        val spaceCount = (lastCharCount - symbolCount) / 2

        var spaces = ""
        var symbols = ""

        repeat(spaceCount) { spaces += SPACE }
        repeat(symbolCount) { symbols += PYRAMID_SYMBOL }

        result.add("$spaces$symbols$spaces")
    }

    return result
}

private class Test {

    @Test
    fun `pyramid n = 2`() {
        generatePyramid(2).also {
            it.size shouldBeEqualTo 2
            it[0] shouldBeEqualTo " # "
            it[1] shouldBeEqualTo "###"
        }
    }

    @Test
    fun `pyramid n = 3`() {
        generatePyramid(3).also {
            it.size shouldBeEqualTo 3
            it[0] shouldBeEqualTo "  #  "
            it[1] shouldBeEqualTo " ### "
            it[2] shouldBeEqualTo "#####"
        }
    }

    @Test
    fun `pyramid n = 4`() {
        generatePyramid(4).also {
            it.size shouldBeEqualTo 4
            it[0] shouldBeEqualTo "   #   "
            it[1] shouldBeEqualTo "  ###  "
            it[2] shouldBeEqualTo " ##### "
            it[3] shouldBeEqualTo "#######"
        }
    }
}
