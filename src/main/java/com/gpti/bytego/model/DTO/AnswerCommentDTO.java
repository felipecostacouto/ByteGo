package com.gpti.bytego.model.DTO;

public class AnswerCommentDTO
{
    public String professorLogin;
    public String comment;

    public AnswerCommentDTO(String professorLogin, String comment) {
        this.professorLogin = professorLogin;
        this.comment = comment;
    }

    public String getProfessorLogin() {
        return professorLogin;
    }

    public String getComment() {
        return comment;
    }
}
