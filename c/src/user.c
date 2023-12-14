#include <stdlib.h>
#include <string.h>
#include "user.h"

User* User_create(char* name, char* email) {
    User* user = malloc(sizeof(*user));
    strncpy(user->name, name, sizeof(user->name) - 1);
    strncpy(user->email, email, sizeof(user->email) - 1);

    return user;
}

