#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "discount_applier.h"



bool apply_v1(float discount, User* users, int userCount) {
    char message[MAX_MESSAGE_LENGTH];
    sprintf(message, "You've got a new discount of %.2f", discount);
    // Bug! Should be `(0, len(users))`
    for (int i = 1; i < userCount; i++) {
        User user = users[i];
        notify_discount(&user, message);
    }
    return true;
}
