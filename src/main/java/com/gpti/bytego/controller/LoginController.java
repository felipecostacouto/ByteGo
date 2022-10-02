package com.gpti.bytego.controller;

import com.gpti.bytego.model.service.UserService;
import org.json.JSONObject;

public class LoginController
{
    public JSONObject login(String username, String password)
    {
        UserService userService = new UserService();
        return new JSONObject(userService.getUserDTO(username, password));
    }

    public JSONObject register(String username, String password, byte[] imageProfile, String name)
    {
        UserService userService = new UserService();
        return new JSONObject(userService.createNewUser(username, password, imageProfile, name));
    }
}
