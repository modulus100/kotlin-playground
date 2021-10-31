package playground.autocomplete

data class TrieNode(
    val char: String = "",
    val isLast: Boolean = false,
    val children: MutableMap<String, TrieNode> = mutableMapOf()) {

    fun insertChild(node: TrieNode) {
        children[node.char] = node
    }

    fun findAllMatches(): MutableList<String> {
        val matches = mutableListOf<String>()
        findMatches(node = this, input = "", matches = matches)
        return matches
    }

    private fun findMatches(node: TrieNode, input: String, matches: MutableList<String>) {
        if ((node.children.isEmpty() || node.isLast) && input != "") {
            matches.add(input)
        }

        node.children.values.forEach {
            findMatches(it, input + it.char, matches)
        }
    }
}

class TextAutocomplete {
    private val root = TrieNode()

    fun insert(input: String) {
        var node = root
        val lastIndex = input.length - 1

        input.forEachIndexed { index, c ->
            val char = c.toString()

            if (!node.children.containsKey(char)) {
                node.insertChild(TrieNode(char, lastIndex == index))
            }
            node = node.children[char]!!
        }
    }

    fun find(input: String): TrieNode? {
        var node = root

        input.forEach {
            val char = it.toString()

            if (char == node.char) {
                return node
            }

            if (!node.children.containsKey(char)) {
                return null
            }

            node = node.children[char]!!
        }

        return node
    }
}