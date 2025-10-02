package org.sammancoaching

import io.mockk.verify
import io.mockk.mockk
import kotlin.test.Test

class DiscountApplierTest {
    val notifier: Notifier = mockk(relaxed = true)
    val user1 = User("user1", "user1@example.com")
    val user2 = User("user2", "user2@example.com")

    @Test
    fun should_notify_when_applying_discount_for_user_v1() {
        val discountApplier = DiscountApplier(notifier)

        discountApplier.applyV1(10.0, listOf(user1))

        verify {
            notifier.notify(user1, "You've got a new discount of 10,000000")
        }
    }

    @Test
    fun should_notify_twice_when_applying_discount_for_two_users_v2() {
        val discountApplier = DiscountApplier(notifier)

        discountApplier.applyV1(10.0, listOf(user1, user2))

        verify {
            notifier.notify(user1, "You've got a new discount of 10,000000")
            notifier.notify(user2, "You've got a new discount of 10,000000")
        }
    }
}