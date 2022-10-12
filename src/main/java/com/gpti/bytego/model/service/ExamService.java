package com.gpti.bytego.model.service;

import com.gpti.bytego.model.DAO.Exam.ExamDao;
import com.gpti.bytego.model.DAO.Exam.SpecificExamDaoInterface;
import com.gpti.bytego.model.DTO.ClassDTO;
import com.gpti.bytego.model.DTO.ExamDTO;
import com.gpti.bytego.model.entity.exam.Exam;
import com.gpti.bytego.model.entity.exam.SpecificExamInterface;
import com.gpti.bytego.model.entity.user.UserType;

import java.util.ArrayList;

public class ExamService
{
    ExamDao examDao = new ExamDao();

    public void fillClassWithExams(ClassDTO classDTO, UserType userType, String studentLogin)
    {
        classDTO.exams = new ArrayList<>();
        ArrayList<Exam> exams = examDao.findAllByClassID(classDTO.classID);
        SpecificUserService specificUserService = UserTypeMapper.getUserServiceByUser(userType);

        assert specificUserService != null;
        for (Exam exam : exams)
        {
            for (SpecificExamDaoInterface specificExamDao : specificUserService.getAllExamsDAOs())
            {
                for (SpecificExamInterface specificExam : specificExamDao.findAllByExamID(exam.getID()))
                {
                    Exam parentExam = specificExamDao.findParentExamByID(specificExam.getID());
                    ExamDTO examDTO = new ExamDTO(
                            parentExam.getID(),
                            parentExam.getName(),
                            parentExam.getTimeToDeliverInSeconds(),
                            parentExam.getClosedQuestionsAmount(),
                            parentExam.getOpenQuestionsAmount(),
                            specificExam.getSpecificExamDTO(),
                            null
                    );
                    classDTO.exams.add(examDTO);

                    new QuestionService().fillExamWithQuestions(examDTO, studentLogin);
                }
            }
        }
    }
}
