package org.sammancoaching

class DiscountApplier(private val notifier: Notifier) {
    fun applyV1(discount: Double, users: List<User>) {
        for (i in 1..<users.size) { // <- Bug, should be `i = 0`
            val message = String.format("You've got a new discount of %f", discount)
            val user = users.get(i)
            notifier.notify(user, message)
        }
    }

    fun applyV2(discount: Double, users: List<User>) {
        for (i in users.indices) {
            val message = String.format("You've got a new discount of %f", discount)
            val user = users.get(0) // <- Bug, should be .get(i), not .get(0);
            notifier.notify(user, message)
        }
    }
}