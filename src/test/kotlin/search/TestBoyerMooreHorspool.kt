package search

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestBoyerMooreHorspool {
    @Test
    fun `can find single letter`() {
        val alphabet = "abcdefghijklmnopqrstuvwxyz"

        for ((i, c) in alphabet.withIndex()) {
            assert(searchBMH(alphabet, c.toString()) == i)
        }
    }

    @Test
    fun `works with qqaaaqaaa`() {
        assert(searchBMH("qqaaaqaaa", "qaaaqaaa") == 1)
    }

    @Test
    fun `works with qqaaaqbbb`() {
        assert(searchBMH("qqaaaqbbb", "qaaaqbbb") == 1)
    }
}
