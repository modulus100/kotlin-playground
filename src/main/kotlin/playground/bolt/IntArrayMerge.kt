package playground.bolt

import java.util.*

class IntArrayMerge {
    fun merge(nums1: IntArray, nums2: IntArray): IntArray {
        val pq = PriorityQueue<Int>()

//        nums1.forEach(pq::add)
//        nums2.forEach(pq::add)

        var i = 0
        while (!pq.isEmpty()) {
            nums1[i++] = pq.poll()
        }

        val test: Int? =  pq.peek()

        return nums1
    }
}

fun main() {
    val res = IntArrayMerge().merge(intArrayOf(1, 2, 3, 0, 0, 0), intArrayOf(2, 5, 6))

    println(res.forEach(::println))
}