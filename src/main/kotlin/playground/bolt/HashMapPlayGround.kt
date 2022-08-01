package playground.bolt

fun main() {

    val hm = hashMapOf<String, Int>()
    val str = "aabbcc"

    val list = str.map { it.toString() }
        .groupBy { it }
        .map { it.key to it.value.size }
        .toMap().values
        .toHashSet()

    val list2 = str.map { it.toString() }
        .groupBy { it }
        .map { it.value.size }
        .toHashSet()

    val strings = listOf("a1", "a2", "a3", "a1", "a3")
    val map = hashMapOf<String, Int>()

    strings.forEach {
        if (map.containsKey(it)) {
            map[it] = map[it]!! + 1
        } else {
            map[it] = 1
        }
    }

    fun removeDuplicates(nums: IntArray): Int {
        return nums.toHashSet().size
    }

    val mx = Math.max(1 , 2)

    val list3 = listOf(1, 2, 3, 5, 4)
    println(list3.sortedByDescending { it })

    println(map)

    for (i in 1..10) print(i)

//    println(list)
}