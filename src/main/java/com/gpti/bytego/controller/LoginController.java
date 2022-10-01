package com.gpti.bytego.controller;

import com.gpti.bytego.model.service.UserService;
import org.json.JSONObject;

public class LoginController implements LoginInterface
{
    @Override
    public JSONObject login(String username, String password) {
        UserService userService = new UserService(username, password);
        return new JSONObject(userService.getUserDTO());
    }

    @Override
    public JSONObject register(String username, String password, byte[] imageProfile, String name)
    {
        UserService userService = new UserService(username, password, imageProfile, name);
        return new JSONObject(userService.createNewUser());
    }
}
