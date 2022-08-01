package playground.bolt

import java.util.*
import kotlin.Comparator


fun main() {
    // Queue
    val compareByLength: Comparator<String> = compareBy { it.length }
    val namesQueueByLength = PriorityQueue(compareByLength)

    namesQueueByLength.add("Jack")
    namesQueueByLength.add("Alex")

    while (!namesQueueByLength.isEmpty()) {
        println(namesQueueByLength.remove())
    }

    val sv = intArrayOf(4, 5, 1, 2, 3)
    val pq = PriorityQueue<Int>()
    sv.forEach(pq::add)

    while (pq.isEmpty()) {
//        pq.
    }


    // Map
    val items = HashMap<String, Int>()
    items["A"] = 10
    items["B"] = 20

    for ((k, v) in items) {
        println("$k = $v")
    }

    items.forEach { (k, v) ->
        println("$k = $v")
    }


    val str = "aabbc"
    val setSize = str
        .groupBy { it }.values
        .map { it.size }
        .toHashSet()

    if (setSize.size == 1) {
        println("pass")
    } else {
        println("fail")
    }

    val iter = setSize.iterator()
    val first = iter.next()
    val second = iter.next()

    println(first)
    println(second)

    val countMap = hashMapOf<String, Int>()

    str.forEach {
        val key = it.toString()

        if (countMap.containsKey(key)) {
            countMap[key] = countMap[key]!! + 1
        } else {
            countMap[key] = 0
        }
    }

    // Hashset
    val hs = hashSetOf<String>().size
    val hashSetOf1 = hashSetOf(2,13,6,5,2,8)
    val hashSetOf2: HashSet<String> = hashSetOf("Vijay","Ashu" ,"Vijay","Roshan")
    println("......traversing hashSetOf1......")
    for (element in hashSetOf1){
        println(element)
    }

    // Ordering
    class Version(val major: Int, val minor: Int) : Comparable<Version> {
        override fun compareTo(other: Version): Int = when {
            this.major != other.major -> this.major.compareTo(other.major) // compareTo() in the infix form
            this.minor != other.minor -> this.minor.compareTo(other.minor)
            else -> 0
        }
    }

    // Associate by
    data class Person(val firstName: String, val lastName: String)
    val scientists = listOf(Person("Grace", "Hopper"), Person("Jacob", "Bernoulli"), Person("Johann", "Bernoulli"))
    val byLastName = scientists.associateBy({ it.lastName }, { it.firstName })
    val byLastName2 = scientists.associateBy { it.lastName }

    //fun main() {
    //    println(Version(1, 2) > Version(1, 3))
    //    println(Version(2, 0) > Version(1, 5))
    //}


}