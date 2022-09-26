package model.DTO;

import model.entity.user.UserType;

import java.util.ArrayList;

public class UserDTO
{
    public String name;
    public String login;
    public UserType userType;
    public ArrayList<ExamDTO> exams;
    public String password;

    public UserDTO(String name,
                   String login,
                   UserType userType,
                   ArrayList<ExamDTO> exams,
                   String password)
    {
        this.name = name;
        this.login = login;
        this.userType = userType;
        this.exams = exams;
        this.password = password;
    }

    @Override
    public String toString() {
        String examsPrints = "";
        if (exams != null) {
            for (ExamDTO examDTO : exams) examsPrints = examsPrints.concat(examDTO.getPrintExamInfo(2));
        }
        return "UserDTO{" +
                "\n\tname='" + name + '\'' +
                ", \n\tlogin='" + login + '\'' +
                ", \n\tuserType=" + userType +
                ", \n\texams=" + examsPrints +
                ", \n\tpassword='" + password + '\'' +
                "\n}";
    }
}
