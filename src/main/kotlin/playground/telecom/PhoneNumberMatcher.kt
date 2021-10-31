package playground.telecom

data class Node(
    val char: String,
    val isLast: Boolean = false,
    val children: MutableMap<String, Node> = mutableMapOf()) {

    fun insertChildIfMissing(char: String, isLast: Boolean) {
        if (!children.containsKey(char)) {
            children[char] = Node(char, isLast)
        }
    }
}

class PhoneNumberMatcher {
    private val root = Node("+")

    fun insert(phoneNumber: String) {
        validate(phoneNumber)
        var node = root
        val lastIndex = phoneNumber.length - 1

        phoneNumber.drop(1).forEachIndexed { index, c ->
            val char = c.toString()
            node.insertChildIfMissing(char, index == lastIndex)
            node = node.children[char]!!
        }
    }

    fun withPhoneNumber(phoneNumber: String): PhoneNumberMatcher {
        insert(phoneNumber)
        return this
    }

    private fun validate(phoneNumber: String) {
        if (phoneNumber.length < 2) {
            throw Exception("Min phone number length is 2")
        }

        if (phoneNumber.first() != '+') {
            throw Exception("Phone number must start with '+'")
        }

        if (!phoneNumberContainsNumbersOnly(phoneNumber.drop(1))) {
            throw Exception("Phone number is invalid")
        }
    }

    private fun phoneNumberContainsNumbersOnly(phoneNumber: String): Boolean {
        return "[0-9]+".toRegex().matches(phoneNumber)
    }

    fun matches(phoneNumber: String): Boolean {
        validate(phoneNumber)
        var node = root

        phoneNumber.drop(1).forEach {
            val char = it.toString()

            if (!node.children.containsKey(char)) {
                return false
            }

            node = node.children[char]!!
        }

        return true
    }
}