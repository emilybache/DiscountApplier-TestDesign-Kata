package org.sammancoaching

import io.mockk.every
import io.mockk.verify
import io.mockk.mockk
import java.util.List
import kotlin.test.Test

class DiscountApplierTest {
    @Test
    fun should_notify_when_applying_discount_for_user_v1() {
        val notifier: Notifier = mockk()
        val sut = DiscountApplier(notifier)
        val user1 = User("user1", "user1@example.com")

        sut.applyV1(10.0, listOf<User>(user1))

        verify {
            notifier.notify(user1, "You've got a new discount of 10,000000")
        }
    }

    @Test
    fun should_notify_twice_when_applying_discount_for_two_users_v2() {
        val notifier: Notifier = mockk()
        val sut = DiscountApplier(notifier)
        val user1 = User("user1", "user1@example.com")
        val user2 = User("user2", "user2@example.com")

        sut.applyV1(10.0, List.of<User>(user1, user2))

        verify {
            notifier.notify(user1, "You've got a new discount of 10,000000")
            notifier.notify(user2, "You've got a new discount of 10,000000")
        }
    }
}