package com.gpti.bytego.model.service;

import com.gpti.bytego.model.DAO.Class.ClassProfessorDao;
import com.gpti.bytego.model.DAO.Exam.ExamToGradeDao;
import com.gpti.bytego.model.DAO.Exam.GradedExamDao;
import com.gpti.bytego.model.DAO.Exam.SpecificExamDaoInterface;
import com.gpti.bytego.model.entity.classroom.ClassProfessor;

import java.util.ArrayList;

public class ProfessorService implements SpecificUserService
{
    @Override
    public ArrayList<SpecificExamDaoInterface> getAllExamsDAOs()
    {
        ArrayList<SpecificExamDaoInterface> examDAOs = new ArrayList<>();
        examDAOs.add(new ExamToGradeDao());
        examDAOs.add(new GradedExamDao());
        return examDAOs;
    }

    public ArrayList<String> getAllProfessorsByClass(String classID)
    {
        ArrayList<ClassProfessor> classProfessors = new ClassProfessorDao().findAllByClass(classID);
        ArrayList<String> professorLogins = new ArrayList<>();

        for (ClassProfessor c : classProfessors) professorLogins.add(c.getProfessor().getName());

        return professorLogins;
    }
}
