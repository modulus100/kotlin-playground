package playground.bolt

class Battlefield {

    fun solve(): String {
        for (i in 3 downTo 0) {      // 4
            print(i)
        }
        println()

        for (i in 0..5) {      // 4
            print(i)
        }

        println()

        return "works!"
    }
}

fun main() {
    val res = Battlefield().solve()
    println(res)
}

import java.io.*;
import java.util.*;

// To execute Kotlin code, please define a top level function named main

/*
Let's say we have an array of size N, where i'th element is the price of stock at day i.

If you were only allowed to complete at most one transaction (buy one stock and sell it later), design an algorithm to maximize the profit.

Example:
Input: [6,1,5,2,6,3]
Output: 5

*/

// Позорище

//fun main() {
//    val stocks = listOf(6,1,5,2,6,3)
//    // val toBuy = stock.min()
//    // val toSell = stock.max()
//
//    // val toBuyIndex = stock.index(x)
//    // val toSell = tock.index(x)
//
//    //
//    // to sell has to be before to buy
//    // first condition
//    // first big next small =>  no profit
//    //
//    // 1,5 => there is profit => 4 keep the state  save to 1 => best to buy start , best to buy end
//    // next 1, 2 => 1 compate to prev state
//    // next 1, 6 => proofit => 4  =>  if current best to buy > prev
//    // profit = 5 ,  bestToBuy star => 1 (store index), bestToBuy end => 5 (store index)
//    // 1 ,  3 = 2  ,  if compare to prev, we see that prev is bigger, so save it
//
//    var bestToByStart = Inf
//    var bestToSell = 0
//
//    var bestToSell = 0
//    var bestToSellIndex = 0
//
//    var prevProfit = 0
//
//    var bestProfit = 0
//
//    //6,1,5,2,6,3
//
//
//    stocks.stock.forEachIndex { i, elemen ->
//        // 5 < 6
//        if element < bestToByStart {
//            bestToByStart = element
//            bestToByStartIndex = i
//        }
//        // bestToByStart = 1
//        // bestToByStartIndex = 1
//
//
//        // if element > bestToSell {
//        //   bestToSell = element
//        //   bestToSellIndex = i
//        // }
//
//
//        // 0 - 1
//        var currentProfit = bestProfit - element // - 6
//
//        // -1 > 0
//        if currentProfit > bestProfit {
//            bestToSell = element
//            bestToSellIndex = i
//            bestProfit = currentProfit
//        }
//
//    }
//
//
//    return bestProfit
//
//
//}
//
