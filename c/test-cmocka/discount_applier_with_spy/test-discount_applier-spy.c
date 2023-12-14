#include <stdarg.h>
#include <setjmp.h>
#include <stddef.h>
#include <stdbool.h>
#include "cmocka.h"
#include <stdlib.h>
#include <string.h>
#include "discount_applier.h"

char* actual_message;
User* actual_user;


bool __wrap_notify_discount(User* user, char* message);
bool __wrap_notify_discount(User* user, char* message) {
    actual_message = message;
    actual_user = user;
    return mock_type(bool);
}

static void test_apply_discount_with_spy(void **state)
{
    (void)state;  // unused variable

    char name[MAX_NAME_LENGTH];
    char email[MAX_NAME_LENGTH];
    char expected_message[MAX_MESSAGE_LENGTH];

    will_return(__wrap_notify_discount, true);

    strncpy(name, "name", MAX_NAME_LENGTH -1);
    strncpy(email, "email", MAX_NAME_LENGTH -1);
    strncpy(expected_message, "message", MAX_MESSAGE_LENGTH - 1);

    User* user = User_create(name, email);
    User users[1];
    users[0] = *user;

    apply_v1(20.0, users, 1);

    assert_string_equal(expected_message, actual_message);
}




int main(void) {
    const struct CMUnitTest tests[] = {
            cmocka_unit_test(test_apply_discount_with_spy),
            };

    return cmocka_run_group_tests(tests, NULL, NULL);
}
