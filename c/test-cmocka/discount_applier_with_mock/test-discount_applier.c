#include <stdarg.h>
#include <setjmp.h>
#include <stddef.h>
#include <stdbool.h>
#include "cmocka.h"
#include <stdlib.h>
#include <string.h>
#include "discount_applier.h"
#include "notifier.h"

int check_message(const LargestIntegralType actual_value, const LargestIntegralType expected_value);

bool __wrap_notify_discount(User* user, char* message);
bool __wrap_notify_discount(User* user, char* message) {
    check_expected(message);
    return mock_type(bool);
}

int check_message(const LargestIntegralType actual_value, const LargestIntegralType expected_value) {
    char* actual_message = (char*)actual_value;
    char* expected_message = (char*)expected_value;

    if (strcmp(actual_message, expected_message) == 0)
        return 1;
    return 0;
}

static void test_apply_discount_with_mock(void **state)
{
    (void)state;  // unused variable

    char name[MAX_NAME_LENGTH];
    char email[MAX_NAME_LENGTH];
    char message[MAX_MESSAGE_LENGTH];

    will_return(__wrap_notify_discount, true);

    strncpy(name, "name", MAX_NAME_LENGTH -1);
    strncpy(email, "email", MAX_NAME_LENGTH -1);
    strncpy(message, "message", MAX_MESSAGE_LENGTH - 1);

    User* user = User_create(name, email);
    User users[1];
    users[0] = *user;

    expect_check(__wrap_notify_discount, message, check_message, expected_message);


    apply_v1(20.0, users, 1);
}


int main(void) {
    const struct CMUnitTest tests[] = {
            cmocka_unit_test(test_apply_discount_with_mock),
            };

    return cmocka_run_group_tests(tests, NULL, NULL);
}
