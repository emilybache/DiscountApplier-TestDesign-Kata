from dataclasses import dataclass


@dataclass
class User:
    name : str


class Notifier:
    def notify(self, user: User, message: str):
        raise RuntimeError("Can't call this from a unit test, it will make a network call")


class DiscountApplier:
    def __init__(self, notifier: Notifier):
        self.notifier = notifier

    def apply_v1(self, discount: float, users: list[User]):
        # Bug! Should be `range(0, len(users))`
        for i in range(1, len(users)):
            message = f"You've got a new discount of {discount}%"
            user = users[i]
            self.notifier.notify(user, message)

    def apply_v2(self, discount: float, users: list[User]):
        for i in range(0, len(users)):
            message = f"You've got a new discount of {discount}%"
            # Bug! Should be `users[i]`
            user = users[0]
            self.notifier.notify(user, message)

