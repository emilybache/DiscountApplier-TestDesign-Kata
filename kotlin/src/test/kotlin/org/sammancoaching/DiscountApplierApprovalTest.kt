package org.sammancoaching

import io.mockk.mockk
import io.mockk.verify
import org.approvaltests.Approvals
import kotlin.test.Test

class DiscountApplierApprovalTest {

    val spy = StringBuilder()
    val notifier: NotifierSpy = NotifierSpy(spy)
    val user1 = User("user1", "user1@example.com")
    val user2 = User("user2", "user2@example.com")

    @Test
    fun should_notify_when_applying_discount_for_user_v1() {
        val discountApplier = DiscountApplier(notifier)

        discountApplier.applyV1(10.0, listOf(user1))

        Approvals.verify(spy)
    }

    @Test
    fun should_notify_twice_when_applying_discount_for_two_users_v2() {
        val discountApplier = DiscountApplier(notifier)

        discountApplier.applyV1(10.0, listOf(user1, user2))

        Approvals.verify(spy)
    }
}