package com.gpti.bytego.controller;

public interface LoginInterface
{
    String login(String username, String password);

    void register(String username, String password, byte[] imageProfile, String name);
}
