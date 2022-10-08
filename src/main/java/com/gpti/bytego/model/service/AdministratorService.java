package com.gpti.bytego.model.service;

import com.gpti.bytego.model.DAO.Exam.ExamToGradeDao;
import com.gpti.bytego.model.DAO.Exam.GradedExamDao;
import com.gpti.bytego.model.DAO.Exam.SpecificExamDaoInterface;

import java.util.ArrayList;

public class AdministratorService implements SpecificUserService
{
    @Override
    public ArrayList<SpecificExamDaoInterface> getAllExamsDAOs()
    {
        ArrayList<SpecificExamDaoInterface> examDAOs = new ArrayList<>();
        examDAOs.add(new ExamToGradeDao());
        examDAOs.add(new GradedExamDao());
        return examDAOs;
    }
}
