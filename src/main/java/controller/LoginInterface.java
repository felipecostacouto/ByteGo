package controller;

public interface LoginInterface
{
    void login(String username, String password);

    void register(String username, String password, byte[] imageProfile, String name);
}
