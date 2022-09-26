package model.DTO;

import java.util.ArrayList;

public class UserDTO
{
    public String name;
    public String login;
    public String userType;
    public ArrayList<ExamDTO> exams;
    public String password;

    public UserDTO(String name,
                   String login,
                   String userType,
                   ArrayList<ExamDTO> exams,
                   String password)
    {
        this.name = name;
        this.login = login;
        this.userType = userType;
        this.exams = exams;
        this.password = password;
    }
}
