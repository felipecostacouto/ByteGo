package controller;

import model.DTO.UserDTO;
import model.service.UserService;

import javax.ws.rs.*;

@Path("test")
public class LoginController implements LoginInterface
{
    @GET
    @Path("login")
    @Override
    @Produces("text/plain")
    public String login(
            @QueryParam("username") String username,
            @QueryParam("password") String password)
    {
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
