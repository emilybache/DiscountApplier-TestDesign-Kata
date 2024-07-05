package org.codingdojo;

import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DiscountApplierTest {
  @Test
  void should_notify_twice_when_applying_discount_for_two_users_v1() {
    var notifier = mock(Notifier.class);
    var sut = new DiscountApplier(notifier);
    var user1 = new User("user1", "user1@example.com");

    sut.applyV1(10.0, List.of(user1));

    verify(notifier).notify(user1, "You've got a new discount of 10,000000");
  }

  @Test
  void should_notify_twice_when_applying_discount_for_two_users_v2() {
    var notifier = mock(Notifier.class);
    var sut = new DiscountApplier(notifier);
    var user1 = new User("user1", "user1@example.com");
    var user2 = new User("user2", "user2@example.com");

    sut.applyV1(10.0, List.of(user1, user2));

    verify(notifier).notify(user1, "You've got a new discount of 10,000000");
    verify(notifier).notify(user2, "You've got a new discount of 10,000000");
  }

}
