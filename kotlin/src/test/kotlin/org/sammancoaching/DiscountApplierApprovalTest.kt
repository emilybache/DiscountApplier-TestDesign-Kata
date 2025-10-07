package org.sammancoaching

import org.approvaltests.Approvals
import org.approvaltests.core.Options
import kotlin.test.Test

class DiscountApplierApprovalTest {

    val spy = StringBuilder()
    val notifier: NotifierSpy = NotifierSpy(spy)
    val user1 = User("user1", "user1@example.com")
    val user2 = User("user2", "user2@example.com")

    @Test
    fun should_notify_when_applying_discount_for_user_v1() {
        spy.append("Notify one user about a discount\n")
        val discountApplier = DiscountApplier(notifier)

        discountApplier.applyV1(10.0, listOf(user1))

        val expected = """
            Notify one user about a discount
            notify user1 with message
            """.trimIndent()
        Approvals.verify(spy, Options().inline(expected))
    }

    @Test
    fun should_notify_twice_when_applying_discount_for_two_users_v2() {
        spy.append("Notify two users about a discount\n")
        val discountApplier = DiscountApplier(notifier)

        discountApplier.applyV1(10.0, listOf(user1, user2))

        val expected = """
            Notify two users about a discount
            notify user1 with message
            notify user2 with message
            """.trimIndent()
        Approvals.verify(spy, Options().inline(expected))
    }
}