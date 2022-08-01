package playground.bolt

class SecondLiveCoding {

    fun solve(arr: List<Int> = listOf(1, 2, 3, 4, 5, 6), lim: Int = 7) {
        var index = 0
        var sum = arr[index]
        println(Pair(arr[index], sum))

        arr.drop(1).forEach {
            if (sum + it > lim) {
                while (sum + it > lim)
                    sum -= arr[index++]
            } else {
                sum += it
            }
            println(Pair(it, sum))
        }
    }

    fun solveIntArr(arr: IntArray = intArrayOf(1, 2, 3, 4, 5, 6), lim: Int = 7) {
        var index = 0
        var sum = arr[index]
        println(Pair(arr[index], sum))

        arr.drop(1).forEach {
            if (sum + it > lim) {
                while (sum + it > lim)
                    sum -= arr[index++]
            } else {
                sum += it
            }
            println(Pair(it, sum))
        }
    }
}

fun main() {
    SecondLiveCoding().solve()
//    SecondLiveCoding().solveIntArr()
}