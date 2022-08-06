package playground.twilio

fun main() {
    // num of messages to send
    val counter = MessageCounter(maxTextLength = 80, actualTextLength = 180)
    val counter2 = MessageCounter2(maxTextLength = 80, actualTextLength = 180)
    // should be 3
    println(counter.messagesToSend)
    println(counter2.messagesToSend)
}

// similar to the case class in scala
data class MessageCounter(val maxTextLength: Int, val actualTextLength: Int) {
    val messagesToSend get() = (actualTextLength / maxTextLength) +
            if (maxTextLength % actualTextLength == 0) 0 else 1
}

class MessageCounter2(
    private val maxTextLength: Int,
    private val actualTextLength: Int) {

    val messagesToSend get() = (actualTextLength / maxTextLength) +
            if (maxTextLength % actualTextLength == 0) 0 else 1
}