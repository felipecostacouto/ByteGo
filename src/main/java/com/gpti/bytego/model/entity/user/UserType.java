package com.gpti.bytego.model.entity.user;

public enum UserType
{
    STUDENT("STUDENT"),
    PROFESSOR("PROFESSOR"),
    ADMINISTRATOR("ADMINISTRATOR");

    private final String userType;

    UserType(String userType)
    {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return userType;
    }
}
