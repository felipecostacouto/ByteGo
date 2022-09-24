package controller;

import model.DTO.UserDTO;
import model.service.UserService;

public class LoginController implements LoginInterface
{
    @Override
    public void login(String username, String password) {
        UserService userService = new UserService(username, password);
        sendUserDataToView(userService.getUserDTO());
    }

    @Override
    public void register(String username, String password, byte[] imageProfile, String name)
    {
        UserService userService = new UserService(username, password);
        sendUserDataToView(userService.createNewUser());
    }

    private void sendUserDataToView(UserDTO userDTO)
    {

    }
}
