package com.gpti.bytego.model.service;

import com.gpti.bytego.model.DAO.Class.ClassProfessorsDao;
import com.gpti.bytego.model.DAO.Exam.ExamToGradeDao;
import com.gpti.bytego.model.DAO.Exam.GradedExamDao;
import com.gpti.bytego.model.DTO.ExamDTO;
import com.gpti.bytego.model.entity.classroom.ClassProfessors;

import java.util.ArrayList;

public class ProfessorService implements SpecificUserService
{
    private final String login;
    private final ExamService examToGradeService = new ExamService(new ExamToGradeDao());
    private final ExamService gradedExamService = new ExamService(new GradedExamDao());

    public ProfessorService(String login)
    {
        this.login = login;
    }

    @Override
    public ArrayList<ExamDTO> getAllExamsDTO()
    {
        ArrayList<ExamDTO> exams = new ArrayList<>();
        exams.addAll(examToGradeService.getAllExamDTOsByUserLogin(login));
        exams.addAll(gradedExamService.getAllExamDTOsByUserLogin(login));
        return exams;
    }

    public ArrayList<String> getAllProfessorsByClass(String classID)
    {
        ArrayList<ClassProfessors> classProfessors = new ClassProfessorsDao().findAllByClass(classID);
        ArrayList<String> professorLogins = new ArrayList<>();

        for (ClassProfessors c : classProfessors) professorLogins.add(c.getProfessor().getName());

        return professorLogins;
    }
}
