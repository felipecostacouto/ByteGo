package com.gpti.bytego.controller;

import org.json.JSONObject;

public interface LoginInterface
{
    JSONObject login(String username, String password);

    JSONObject register(String username, String password, byte[] imageProfile, String name);
}
