package org.sammancoaching

class NotifierSpy(val spy: StringBuilder) : Notifier {
    override fun notify(user: User, message: String) {
        spy.append("notify ${user.name} with message $message\n")
    }

}
