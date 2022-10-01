package com.gpti.bytego.model.entity.exam;

public enum ExamType
{
    EXAM_TO_TAKE("EXAM_TO_TAKE"),
    EXAM_TO_GRADE("EXAM_TO_GRADE"),
    GRADED_EXAM("GRADED_EXAM");

    private final String examType;

    ExamType(String examType)
    {
        this.examType = examType;
    }

    @Override
    public String toString() {
        return examType;
    }
}
