package com.gpti.bytego.model.DTO;

public class QuestionAnswerDTO
{
    public String studentLogin;
    public char alternative;
    public String text;
    public byte[] image;
    public float score;
    public Long questionID;
    public String comment;
    public String professorLogin;

    public QuestionAnswerDTO(
            String studentLogin,
            char alternative,
            String text,
            byte[] image,
            float score,
            Long questionID,
            String comment,
            String professorLogin)
    {
        this.studentLogin = studentLogin;
        this.alternative = alternative;
        this.text = text;
        this.image = image;
        this.score = score;
        this.questionID = questionID;
        this.comment = comment;
        this.professorLogin = professorLogin;
    }

    public String getStudentLogin() {
        return studentLogin;
    }

    public char getAlternative() {
        return alternative;
    }

    public String getText() {
        return text;
    }

    public byte[] getImage() {
        return image;
    }

    public float getScore() {
        return score;
    }

    public Long getQuestionID() {
        return questionID;
    }

    public String getComment() {
        return comment;
    }

    public String getProfessorLogin() {
        return professorLogin;
    }
}
