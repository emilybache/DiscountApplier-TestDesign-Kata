#ifndef SAMPLE_MAIL_SENDING_H
#define SAMPLE_MAIL_SENDING_H

#include <stdbool.h>
#include "user.h"
#include "notifier.h"

#define MAX_MESSAGE_LENGTH 100

bool apply_v1(float discount, User* users, int userCount);

#endif //SAMPLE_MAIL_SENDING_H
