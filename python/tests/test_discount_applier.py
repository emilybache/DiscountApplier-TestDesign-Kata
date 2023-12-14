from discount_applier import DiscountApplier, Notifier
from discount_applier import User


class SpyNotifier(Notifier):
    def __init__(self):
        self.notified = []

    def notify(self, user, message):
        self.notified.append(user.name)


def test_apply_v1():
    notifier = SpyNotifier()
    user1 = User("user1")
    discount_applier = DiscountApplier(notifier)
    discount_applier.apply_v1(100, [user1])
    assert user1.name in notifier.notified


def test_apply_v2():
    notifier = SpyNotifier()
    user1 = User("user1")
    user2 = User("user2")
    discount_applier = DiscountApplier(notifier)
    discount_applier.apply_v2(100, [user1, user2])
    assert user1.name in notifier.notified
    assert user2.name in notifier.notified
