package com.gpti.bytego.controller;

import com.gpti.bytego.model.DTO.UserDTO;
import com.gpti.bytego.model.service.UserService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/test")
public class LoginController implements LoginInterface
{
    @GET
    @Produces("text/plain")
    @Override
    public String login(String username, String password) {
        UserService userService = new UserService(username, password);
        sendUserDataToView(userService.getUserDTO());
        return "asdasdasd";
    }

    @Override
    public void register(
            @PathParam("username") String username,
            @PathParam("password") String password,
            @PathParam("imageProfile") byte[] imageProfile,
            @PathParam("name") String name)
    {
        UserService userService = new UserService(username, password, imageProfile, name);
        sendUserDataToView(userService.createNewUser());
    }

    private void sendUserDataToView(UserDTO userDTO)
    {
        System.out.println(userDTO);
    }
}
