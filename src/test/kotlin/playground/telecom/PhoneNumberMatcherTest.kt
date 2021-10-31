package playground.telecom

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class PhoneNumberMatcherTest {

    @Test
    fun `matches - phone number matches`() {
        // Arrange
        val matcher = PhoneNumberMatcher()
            .withPhoneNumber("+37255")

        // Act
        val match = matcher.matches("+372")

        // Assert
        Assertions.assertTrue(match)
    }

    @Test
    fun `matches - long number doesn't match`() {
        // Arrange
        val matcher = PhoneNumberMatcher()
            .withPhoneNumber("+37255")

        // Act
        val match = matcher.matches("+3729034")

        // Assert
        Assertions.assertFalse(match)
    }

    @Test
    fun `matches - two different numbers match`() {
        // Arrange
        val matcher = PhoneNumberMatcher()
            .withPhoneNumber("+37255")
            .withPhoneNumber("+37145")
            .withPhoneNumber("+71595")

        // Act
        val matchFirst = matcher.matches("+3725")
        val matchSecond = matcher.matches("+3714")

        // Assert
        Assertions.assertTrue(matchFirst)
        Assertions.assertTrue(matchSecond)
    }

    @Test
    fun `matches - one matches numbers second doesn't`() {
        // Arrange
        val matcher = PhoneNumberMatcher()
            .withPhoneNumber("+37255")
            .withPhoneNumber("+37145")
            .withPhoneNumber("+71595")

        // Act
        val matchFirst = matcher.matches("+3725")
        val matchSecond = matcher.matches("+37146")

        // Assert
        Assertions.assertTrue(matchFirst)
        Assertions.assertFalse(matchSecond)
    }
}