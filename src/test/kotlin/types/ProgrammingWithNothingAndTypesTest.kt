@file:Suppress("RemoveRedundantBackticks")

package types


import toInt
import kotlin.test.Test
import kotlin.test.assertEquals

class ProgrammingWithNothingAndTypesTest {
    @Test fun `conversion to kotlin ints`() {
        assertEquals(zero<Int>().toKotlin(), (0))
        assertEquals(one<Int>().toKotlin(), (1))
        assertEquals(two<Int>().toKotlin(), (2))
    }

    @Test fun `conversion to kotlin booleans`() {
        assertEquals(true_<Boolean>().toKotlin(), (true))
        assertEquals(false_<Boolean>().toKotlin(), (false))
    }

    @Test fun `if function`() {
        assertEquals(if_<String>()(true_())("foo")("bar"), ("foo"))
        assertEquals(if_<String>()(false_())("foo")("bar"), ("bar"))
    }

    @Test fun `is zero predicate`() {
        assertEquals(isZero<Boolean>()(zero()).toKotlin(), (true))
        assertEquals(isZero<Boolean>()(one()).toKotlin(), (false))
        assertEquals(isZero<Boolean>()(three()).toKotlin(), (false))
    }

    @Test fun `increment`() {
        assertEquals(increment<Int>()(zero()).toKotlin(), (1))
        assertEquals(increment<Int>()(one()).toKotlin(), (2))
        assertEquals(increment<Int>()(two()).toKotlin(), (3))
        assertEquals(increment<Int>()(three()).toKotlin(), (4))

        assertEquals(increment<Int>()(increment<Int>()(zero())).toKotlin(), (2))
    }

    @Test fun `decrement`() {
        assertEquals(decrement<Int>()(zero()).toKotlin(), (0)) // no negative numbers
        assertEquals(decrement<Int>()(one()).toKotlin(), (0))
        assertEquals(decrement<Int>()(two()).toKotlin(), (1))
        assertEquals(decrement<Int>()(three()).toKotlin(), (2))

        assertEquals(decrement<Int>()(decrement<(L<Int>)->Int>()(three())).toKotlin(), (1))
    }

    @Test fun `addition`() {
        assertEquals(add<Int>()(zero())(zero()).toKotlin(), (0))
        assertEquals(add<Int>()(zero())(one()).toKotlin(), (1))
        assertEquals(add<Int>()(one())(one()).toKotlin(), (2))
        assertEquals(add<Int>()(two())(three()).toKotlin(), (5))
    }

    @Test fun `multiplication`() {
        assertEquals(multiply<Int>()(zero())(zero()).toInt(), (0))
        assertEquals(multiply<Int>()(zero())(one()).toInt(), (0))
        assertEquals(multiply<Int>()(one())(one()).toInt(), (1))
        assertEquals(multiply<Int>()(three())(five()).toInt(), (15))
    }

}