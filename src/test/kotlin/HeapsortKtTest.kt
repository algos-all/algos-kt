import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HeapsortKtTest {

    @Test
    fun `sink works for empty list`() {
        assert(sink(mutableListOf<Int>(), 0).isEmpty())
        assertEquals(1, 1)
    }
}