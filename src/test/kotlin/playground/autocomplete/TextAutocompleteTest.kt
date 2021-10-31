package playground.autocomplete

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class TextAutocompleteTest {

    @Test
    fun `findAllMatches - returns all matches for empty input`() {
        // Arrange
        val autocomplete = TextAutocomplete()
        val words = listOf(
            "ant", "anthology", "antagonist", "antonym",
            "fun", "function", "factory",
            "trie", "trigger", "trigonometry", "tripod"
        )

        words.forEach {
            autocomplete.insert(it)
        }

        // Act
        val node = autocomplete.find("")
        val matches = node?.findAllMatches()

        // Assert
        Assertions.assertNotNull(node)
        Assertions.assertEquals(words.size, matches?.size)
        Assertions.assertEquals(words, matches)
    }

    @Test
    fun `findAllMatches - returns empty matches for not existing input`() {
        // Arrange
        val autocomplete = TextAutocomplete()
        val words = listOf(
            "ant", "anthology", "antagonist", "antonym",
            "fun", "function", "factory",
            "trie", "trigger", "trigonometry", "tripod"
        )

        words.forEach {
            autocomplete.insert(it)
        }

        // Act
        val node = autocomplete.find("test")

        // Assert
        Assertions.assertNull(node)
    }

    @Test
    fun `findAllMatches - returns all endings what start with 'ant'`() {
        // Arrange
        val autocomplete = TextAutocomplete()
        val words = listOf(
            "ant", "anthology", "antagonist", "antonym",
            "fun", "function", "factory",
            "trie", "trigger", "trigonometry", "tripod"
        )

        val antWords = listOf(
            "hology", "agonist", "onym"
        )

        words.forEach {
            autocomplete.insert(it)
        }

        // Act
        val node = autocomplete.find("ant")
        val matches = node?.findAllMatches()

        // Assert
        Assertions.assertNotNull(node)
        Assertions.assertEquals(antWords.size, matches?.size)
        Assertions.assertEquals(antWords, matches)
    }
}