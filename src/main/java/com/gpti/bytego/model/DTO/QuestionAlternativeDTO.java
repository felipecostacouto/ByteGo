package com.gpti.bytego.model.DTO;

public class QuestionAlternativeDTO
{
    public char alternative;
    public String text;
    public byte[] image;

    public QuestionAlternativeDTO(char alternative, String text, byte[] image) {
        this.alternative = alternative;
        this.text = text;
        this.image = image;
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
}
