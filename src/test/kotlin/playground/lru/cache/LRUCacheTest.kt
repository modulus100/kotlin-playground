package playground.lru.cache

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class LRUCacheTest {

    @Test
    fun `add 6 items if 5 is max size - check if the first one has been removed`() {
        // Arrange
        val cache = LRUCache<Int, Int>(5)

        // Act
        println("set(1,1)")
        cache[1] = 1
        println("set(2,2)")
        cache[2] = 2
        println("set(3,3)")
        cache[3] = 3
        println("set(4,4)")
        cache[4] = 4

        val res1 = cache[1]
        println("get(1) expected val: 1, actual val: $res1")

        val res2 = cache[2]
        println("get(2) expected val: 2, actual val: $res2")

        val res3 = cache[9]
        println("get(9) expected val: null, actual val: $res3")

        println("set(5,5)")
        cache[5] = 5
        println("set(6,6)")
        cache[6] = 6

        val res4 = cache[3]
        println("get(3) expected val: null, actual val: $res4")

        // Assert
        Assertions.assertNull(res4)
    }

    @Test
    fun `max size 1 - returns previously saved state has been overwritten`() {
        // Arrange
        val cache = LRUCache<Int, Int>(1)

        // Act
        cache.set(1, 1)
        cache.set(2, 2)

        // Assert
        Assertions.assertEquals(null, cache[1])
        Assertions.assertEquals(2, cache[2])
    }

    @Test
    fun `get and set - returns cached value`() {
        // Arrange
        val cache = LRUCache<Int, Int>(2)

        // Act
        cache.set(1, 1)
        cache.set(2, 2)

        // Assert
        Assertions.assertEquals(1, cache[1])
        Assertions.assertEquals(2, cache[2])
    }
}