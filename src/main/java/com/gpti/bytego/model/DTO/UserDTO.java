package com.gpti.bytego.model.DTO;

import com.gpti.bytego.model.entity.user.UserType;

import java.util.ArrayList;

public class UserDTO
{
    public String name;
    public String login;
    public UserType userType;
    public ArrayList<ClassDTO> classes;
    public String password;

    public UserDTO(String name,
                   String login,
                   UserType userType,
                   ArrayList<ClassDTO> classes,
                   String password)
    {
        this.name = name;
        this.login = login;
        this.userType = userType;
        this.classes = classes;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public UserType getUserType() {
        return userType;
    }

    public ArrayList<ClassDTO> getClasses() {
        return classes;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        String classesPrints = "";
        if (classes != null) {
            for (ClassDTO classDTO : classes) classesPrints = classesPrints.concat(classDTO.getPrintExamInfo(2));
        }

        return "UserDTO{" +
                "\n\tname='" + name + '\'' +
                ", \n\tlogin='" + login + '\'' +
                ", \n\tuserType=" + userType +
                ", \n\tclasses=" + classesPrints +
                ", \n\tpassword='" + password + '\'' +
                "\n}";
    }
}
