package model.DAO.Exam;

import model.entity.Exam.Exam;
import model.entity.Exam.SpecificExamInterface;

import java.util.ArrayList;

public interface SpecificExamDaoInterface
{
    ArrayList<SpecificExamInterface> findAllExamByUserLogin(String login);

    Exam findParentExamByID(Long examID);
}
