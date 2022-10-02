package com.gpti.bytego.model.DTO;

import java.util.ArrayList;

public class ClassDTO
{
    public String classID;
    public ArrayList<String> professorsLogins;
    public String subject;
    public ArrayList<ExamDTO> exams;

    public ClassDTO(String classID, ArrayList<String> professorsLogins, String subject, ArrayList<ExamDTO> exams) {
        this.classID = classID;
        this.professorsLogins = professorsLogins;
        this.subject = subject;
        this.exams = exams;
    }

    public String getClassID() {
        return classID;
    }

    public ArrayList<String> getProfessorsLogins() {
        return professorsLogins;
    }

    public String getSubject() {
        return subject;
    }

    public ArrayList<ExamDTO> getExams() {
        return exams;
    }

    public String getPrintExamInfo(int numberOfTags)
    {
        String tagsSpace = "";
        for (int i = 0; i < numberOfTags; i++) tagsSpace = tagsSpace.concat("\t");
        String examsPrints = "";
        if (exams != null) {
            for (ExamDTO examDTO : exams) examsPrints = examsPrints.concat(examDTO.getPrintExamInfo(2));
        }

        return "\n" + tagsSpace + "ClassDTO{" +
                ", \n" + tagsSpace + "\tclassID='" + classID + '\'' +
                ", \n" + tagsSpace + "\tprofessorLogin='" + professorsLogins + '\'' +
                ", \n" + tagsSpace + "\tsubject='" + subject + '\'' +
                ", \n" + tagsSpace + "\texams=" + examsPrints +
                '}';
    }
}
