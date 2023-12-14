

#ifndef USER_H
#define USER_H

#define MAX_NAME_LENGTH 100

typedef struct User {
    char name[MAX_NAME_LENGTH];
    char email[MAX_NAME_LENGTH];
} User;

User* User_create(char* name, char* email);

#endif //USER_H
