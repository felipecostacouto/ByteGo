package com.gpti.bytego.model.DTO;

public class QuestionAnswerDTO
{
    public Long ID;
    public String studentLogin;
    public char alternative;
    public String text;
    public byte[] image;
    public float score;

    public QuestionAnswerDTO(
            Long ID,
            String studentLogin,
            char alternative,
            String text,
            byte[] image,
            float score)
    {
        this.ID = ID;
        this.studentLogin = studentLogin;
        this.alternative = alternative;
        this.text = text;
        this.image = image;
        this.score = score;
    }

    public Long getID() {
        return ID;
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
}
