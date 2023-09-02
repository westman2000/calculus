@file:Suppress("RemoveRedundantBackticks")


import kotlin.test.Test
import kotlin.test.assertEquals

class ProgrammingWithNothingTest {
    @Test fun `conversion to kotlin ints`() {
        assertEquals(ZERO.toInt(), (0))
        assertEquals(ONE.toInt(), (1))
        assertEquals(TWO.toInt(), (2))
        assertEquals(THREE.toInt(), (3))
        assertEquals(FIVE.toInt(), (5))
        assertEquals(FIFTEEN.toInt(), (15))
        assertEquals(HUNDRED.toInt(), (100))
    }

    @Test fun `conversion to kotlin booleans`() {
        assertEquals(TRUE.toBoolean(), (true))
        assertEquals(FALSE.toBoolean(), (false))
    }

    @Test fun `if function`() {
        assertEquals(IF(TRUE)("foo")("bar").toString(), ("foo"))
        assertEquals(IF(FALSE)("foo")("bar").toString(), ("bar"))
    }

    @Test fun `is zero predicate`() {
        assertEquals(IS_ZERO(ZERO).toBoolean(), (true))
        assertEquals(IS_ZERO(ONE).toBoolean(), (false))
        assertEquals(IS_ZERO(THREE).toBoolean(), (false))
    }

    @Test fun `increment`() {
        assertEquals(INCREMENT(ZERO).toInt(), (1))
        assertEquals(INCREMENT(ONE).toInt(), (2))
        assertEquals(INCREMENT(TWO).toInt(), (3))
        assertEquals(INCREMENT(THREE).toInt(), (4))

        assertEquals(INCREMENT(INCREMENT(ZERO)).toInt(), (2))
    }

    @Test fun `decrement`() {
        assertEquals(DECREMENT(ZERO).toInt(), (0)) // no negative numbers
        assertEquals(DECREMENT(ONE).toInt(), (0))
        assertEquals(DECREMENT(TWO).toInt(), (1))
        assertEquals(DECREMENT(THREE).toInt(), (2))

        assertEquals(DECREMENT(DECREMENT(THREE)).toInt(), (1))
    }

    @Test fun `addition`() {
        assertEquals(ADD(ZERO)(ZERO).toInt(), (0))
        assertEquals(ADD(ZERO)(ONE).toInt(), (1))
        assertEquals(ADD(ONE)(ONE).toInt(), (2))
        assertEquals(ADD(TWO)(THREE).toInt(), (5))
    }

    @Test fun `subtraction`() {
        assertEquals(SUBTRACT(ZERO)(ZERO).toInt(), (0))
        assertEquals(SUBTRACT(ONE)(ZERO).toInt(), (1))
        assertEquals(SUBTRACT(ONE)(ONE).toInt(), (0))
        assertEquals(SUBTRACT(FIVE)(TWO).toInt(), (3))
    }

    @Test fun `multiplication`() {
        assertEquals(MULTIPLY(ZERO)(ZERO).toInt(), (0))
        assertEquals(MULTIPLY(ZERO)(ONE).toInt(), (0))
        assertEquals(MULTIPLY(ONE)(ONE).toInt(), (1))
        assertEquals(MULTIPLY(THREE)(FIVE).toInt(), (15))
    }

    @Test fun `power`() {
        assertEquals(POWER(ZERO)(ONE).toInt(), (0))
        assertEquals(POWER(ZERO)(ZERO).toInt(), (1))
        assertEquals(POWER(TWO)(THREE).toInt(), (8))
        assertEquals(POWER(THREE)(FIVE).toInt(), (243))
    }

    @Test fun `less or equal`() {
        assertEquals(IS_LESS_OR_EQUAL(ONE)(TWO).toBoolean(), (true))
        assertEquals(IS_LESS_OR_EQUAL(TWO)(TWO).toBoolean(), (true))
        assertEquals(IS_LESS_OR_EQUAL(THREE)(TWO).toBoolean(), (false))
    }

    @Test fun `mod`() {
        assertEquals(MOD(THREE)(TWO).toInt(), (1))
        assertEquals(MOD(POWER(THREE)(THREE))(ADD(THREE)(TWO)).toInt(), (2))
    }

    @Test fun `pairs`() {
        val pair = PAIR(THREE)(FIVE)
        assertEquals(LEFT(pair).toInt(), (3))
        assertEquals(RIGHT(pair).toInt(), (5))
    }

    @Test fun `lists`() {
        val list =
            UNSHIFT(
                UNSHIFT(
                    UNSHIFT(EMPTY)(THREE)
                )(TWO)
            )(ONE)

        assertEquals(FIRST(list).toInt(), (1))
        assertEquals(FIRST(REST(list)).toInt(), (2))
        assertEquals(FIRST(REST(REST(list))).toInt(), (3))

        assertEquals(IS_EMPTY(list).toBoolean(), (false))
        assertEquals(IS_EMPTY(EMPTY).toBoolean(), (true))

        assertEquals(list.toList().map{ it.toInt() }, (listOf(1, 2, 3)))

        assertEquals(PUSH(list)(FIVE).toList().map{ it.toInt() }, (listOf(1, 2, 3, 5)))
    }

    @Test fun `range`() {
        assertEquals(RANGE(ONE)(FIVE).toList().map { it.toInt() }, (listOf(1, 2, 3, 4, 5)))
    }

    @Test fun `fold`() {
        assertEquals(FOLD(RANGE(ONE)(FIVE))(ZERO)(ADD).toInt(), (15))
        assertEquals(FOLD(RANGE(ONE)(FIVE))(ONE)(MULTIPLY).toInt(), (120))
    }

    @Test fun `map`() {
        assertEquals(
            MAP(RANGE(ONE)(FIVE))(INCREMENT).toList().map { it.toInt() },
            (listOf(2, 3, 4, 5, 6))
        )
    }

    @Test fun `chars and strings`() {
        assertEquals(ZED.toChar(), ('z'))
        assertEquals(FIZZBUZZ.toStr(), ("FizzBuzz"))
    }

    @Test fun `division`() {
        assertEquals(DIV(ONE)(ONE).toInt(), (1))
        assertEquals(DIV(TEN)(TWO).toInt(), (5))
        assertEquals(DIV(TEN)(THREE).toInt(), (3))
    }

    @Test fun `to digits`() {
        assertEquals(TO_DIGITS(FIVE).toStr(), ("5"))
        assertEquals(TO_DIGITS(POWER(FIVE)(THREE)).toStr(), ("125"))
    }

    @Test fun `fizz buzz`() {
        assertEquals(
            LIST_OF_FIZZ_BUZZ.toList().joinToString(", ") { it.toStr() },
            ("1, 2, Fizz, 4, 5, Fizz, 7, 8, Fizz, 10, 11, Fizz, 13, 14, FizzBuzz, " +
                    "16, 17, Fizz, 19, 20, Fizz, 22, 23, Fizz, 25, 26, Fizz, 28, 29, FizzBuzz, " +
                    "31, 32, Fizz, 34, 35, Fizz, 37, 38, Fizz, 40, 41, Fizz, 43, 44, FizzBuzz, " +
                    "46, 47, Fizz, 49, 50, Fizz, 52, 53, Fizz, 55, 56, Fizz, 58, 59, FizzBuzz, " +
                    "61, 62, Fizz, 64, 65, Fizz, 67, 68, Fizz, 70, 71, Fizz, 73, 74, FizzBuzz, " +
                    "76, 77, Fizz, 79, 80, Fizz, 82, 83, Fizz, 85, 86, Fizz, 88, 89, FizzBuzz, " +
                    "91, 92, Fizz, 94, 95, Fizz, 97, 98, Fizz, 100")
        )
    }
}
