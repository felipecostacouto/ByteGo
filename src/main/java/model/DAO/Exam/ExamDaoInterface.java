package model.DAO.Exam;

import model.entity.Exam.Exam;
import model.entity.Exam.ExamInterface;

import java.util.ArrayList;

public interface ExamDaoInterface
{
    ArrayList<ExamInterface> findAllExamByUserLogin(String login);

    Exam findParentExamByID(Long examID);
}
